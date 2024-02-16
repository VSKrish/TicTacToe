package strategies;

import java.util.Random;

import models.Board;
import models.Cell;
import models.Move;

public class EasyPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Move playNextMove(Board board, char symbol) {
		Random random = new Random();
		int row = random.nextInt(0, 3);
		int col = random.nextInt(0, 3);
		return new Move(symbol, new Cell(row,col), null);
	}
}
