package strategies;

import models.Board;
import models.Cell;

public interface WinStrategy {
	boolean checkIfWon(Board board, Cell cell);
}
