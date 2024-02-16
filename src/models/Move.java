package models;

public class Move {
	char symbol;
	Cell cell;
	Player player;
	public Move(char symbol, Cell cell, Player player) {
		super();
		this.symbol = symbol;
		this.cell = cell;
		this.player = player;
	}
	
}
