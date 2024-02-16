package strategies;

import models.Board;
import models.Cell;

public class NormalWinStrategy implements WinStrategy {

	@Override
	public boolean checkIfWon(Board boardObj, Cell cell) {
		char[][] board = boardObj.board;
		int row = cell.getRow();
		int col = cell.getCol();
		char ch = board[row][col];
		boolean isAWin = true;
		for(int i=0;i<board.length;i++) {
			if(board[i][col]!=ch)
				isAWin = false;
		}
		if(isAWin)
			return true;
		isAWin = true;
		for(int i=0;i<board[0].length;i++) {
			if(board[row][i]!=ch)
				isAWin = false;
		}
		if(isAWin)
			return true;
		
		isAWin = true;
		for(int i=0,j=0;i<board.length;i++,j++) {
			if(board[i][j]!=ch)
				isAWin = false;
		}
		if(isAWin)
			return true;
		return false;
	}

}
