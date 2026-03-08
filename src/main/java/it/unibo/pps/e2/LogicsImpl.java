package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final BoardImpl board;
	 
    public LogicsImpl(int size){
        this.board = new BoardImpl(size);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knightPos, Pair<Integer, Integer> pawnPos) {
        this.board = new BoardImpl(size, new KnightImpl(knightPos), new PawnImpl(pawnPos));
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= board.getSize() || col >= board.getSize()) {
			throw new IndexOutOfBoundsException();
		}
        board.moveKnight(row, col);
		return board.getKnightPosition().equals(board.getPawnPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.board.getKnightPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.getPawnPosition().equals(new Pair<>(row,col));
	}
}
