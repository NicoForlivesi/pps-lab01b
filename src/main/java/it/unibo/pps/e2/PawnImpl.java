package it.unibo.pps.e2;

public class PawnImpl extends AbstractBoardObject{

    public PawnImpl(int row, int col) {
        super(row, col);
    }

    public PawnImpl(Pair<Integer, Integer> pawn) {
        super(pawn);
    }
}
