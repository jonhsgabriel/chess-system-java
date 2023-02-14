package aplication;

import chess.ChassMatch;

public class Program {

	public static void main(String[] args) {
		
		ChassMatch chessmatch = new ChassMatch();
		UI.printBoard(chessmatch.getPieces());
	}
}
