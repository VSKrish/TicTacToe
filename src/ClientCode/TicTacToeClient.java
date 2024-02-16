package ClientCode;

import java.util.ArrayList;
import java.util.List;

import models.Board;
import models.BotPlayer;
import models.Game;
import models.HumanPlayer;
import models.Player;
import models.User;
import strategies.EasyPlayingStrategy;
import strategies.NormalWinStrategy;
import strategies.WinStrategy;

public class TicTacToeClient {
	public static void main(String[] args) {
		Board board = new Board(3);
		WinStrategy winStrategy = new NormalWinStrategy();
		Player p1 = new HumanPlayer(new User("sai"),'X');
		//Player p2 = new HumanPlayer(new User("krish"),'O');
		Player p2 = new BotPlayer(new EasyPlayingStrategy(), 'O', 143);
		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		Game game = new Game(board,players,winStrategy);
		game.play();
	}
}
