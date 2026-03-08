package it.unibo.pps.e2;

public class KnightImpl extends AbstractBoardObject implements Knight {


    public KnightImpl(int row, int col) {
        super(row, col);
    }

    public KnightImpl(Pair<Integer, Integer> knight) {
        super(knight);
    }

    @Override
    public void moveTo(int row, int col) {
        if(canMoveTo(row, col)) { this.boardObject = new Pair<>(row, col); }
    }

    private boolean canMoveTo(int row, int col) {
        int x = row - getRow();
        int y = col - getCol();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
