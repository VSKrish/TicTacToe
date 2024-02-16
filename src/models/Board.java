package models;

public class Board {
	public char[][] board;
	int size;
	public Board(int size) {
		this.size = size;
		board = new char[size][size];
	}
}
