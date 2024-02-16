package models;

import strategies.BotPlayingStrategy;

public class BotPlayer extends Player {
	
	BotPlayingStrategy playingStrategy;
	char symbol;
	int botID;
	public BotPlayer(BotPlayingStrategy playingStrategy, char symbol, int botID) {
		this.symbol = symbol;
		this.playingStrategy = playingStrategy;
		this.botID = botID;
	}

}
