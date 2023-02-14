package boardgame;

public class Board {
	private int rows;
	private int colums;
	private Piece[][] pieces;
	
	public Board(int rows, int colums) {
		if(rows < 1 || colums < 1) {
			throw new BoardException("Erro criando tabuleiro: tem que haver pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.colums = colums;
		pieces = new Piece[rows][colums];
	}

	public int getRows() {
		return rows;
	}

	public int getColums() {
		return colums;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row,column)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[position.getRow()][position.getColum()];
	}
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já tem uma peça na posição " + position );
		}
		pieces[position.getRow()][position.getColum()] = piece;
		piece.position = position;
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColum()] = null;
		return aux;
	}
	private boolean positionExists(int row, int colum) {
		return row >=0 && row < rows && colum >=0 && colum < colums;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColum());
	}
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return piece(position) != null;
	}
}
