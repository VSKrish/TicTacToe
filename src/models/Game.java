package models;

import java.util.List;
import java.util.Scanner;

import strategies.BotPlayingStrategy;
import strategies.EasyPlayingStrategy;
import strategies.WinStrategy;

public class Game {
	Board board = null;
	List<Player> players = null;
	WinStrategy winStrategy;
	List<Move> move;
	Player lastPlayer = null;
	GameStatus gameStatus = GameStatus.not_started;
	Player winner;
	BotPlayingStrategy botPlayingStrategy = new EasyPlayingStrategy();
	public Game(Board board,List<Player> players,WinStrategy winStrategy) {
		this.board = board;
		this.players = players;
		this.winStrategy = winStrategy;
	}
	void setBotPlayingStrategy(BotPlayingStrategy strategy) {
		this.botPlayingStrategy = strategy;
	}
	void undo() {
		
	}
	public void play() {
		int i=0;
		int numOfIterations = 0;
		int size = board.board.length;
		Scanner sc = new Scanner(System.in);
		while(gameStatus!=GameStatus.completed) {
			Player p = players.get(i);
			if(p instanceof HumanPlayer) {
				HumanPlayer hp = (HumanPlayer)p;
				System.out.println("now its "+hp.user.userName+" turn, please give the box u want to tick: ");
				int row = sc.nextInt();
				int col = sc.nextInt();
				if(!isValid(board.board,row,col)) {
					System.out.println("Invalid entried, please give them again");
					continue;
				}
				board.board[row][col]=hp.symbol;
				Cell cell = new Cell(row, col);
				boolean isWinningMove = winStrategy.checkIfWon(board, cell);
				if(isWinningMove) {
					System.out.println(hp.user.userName+" is the winner");
					return;
				}
			}
			else {
				BotPlayer bp = (BotPlayer)p;
				System.out.println("now its bot"+bp.botID+" turn");
				Move move = botPlayingStrategy.playNextMove(board, bp.symbol);
				Cell cell = move.cell;
				int row = cell.row;;
				int col = cell.col;
				if(!isValid(board.board,row,col))
					continue;
				board.board[row][col]=bp.symbol;
				printBoard(board.board);
				boolean isWinningMove = winStrategy.checkIfWon(board, cell);
				if(isWinningMove) {
					System.out.println(bp.botID+" is the winner");
					return;
				}
			}
			numOfIterations++;
			i++;
			if(i==players.size())
				i=0;
			if(numOfIterations==size*size) {
				System.out.println("Game is a draw");
				return;
			}
		}
	}
	boolean isValid(char[][] board,int row,int col) {
		if(row>=board.length || col>=board.length)
			return false;
		char ch='\u0000';
		if(board[row][col]!=ch)
			return false;
		return true;
	}
	void printBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			System.out.println();
			for(int j=0;j<board.length;j++) {
				System.out.print(board[i][j]+" ");
			}
		}
		System.out.println();
	}
}
