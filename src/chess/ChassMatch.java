package chess;

import boardgame.Board;

public class ChassMatch {
	private Board board;
	
	public ChassMatch() {
		board = new Board(8,8);
	}
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColums()];
		for(int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColums(); i++) {
				mat[i][j] = (ChessPiece)board.piece(i,j);
			}
		}
		return mat;
	}
}
