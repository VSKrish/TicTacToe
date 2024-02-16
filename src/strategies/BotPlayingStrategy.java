package strategies;

import models.Board;
import models.Move;

public interface BotPlayingStrategy {
	Move playNextMove(Board board,char symbol);
}
