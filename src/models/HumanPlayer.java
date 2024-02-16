package models;

public class HumanPlayer extends Player {
	
	User user;
	char symbol;
	public HumanPlayer(User user, char symbol) {
		this.symbol = symbol;
		this.user = user;
	}

}
