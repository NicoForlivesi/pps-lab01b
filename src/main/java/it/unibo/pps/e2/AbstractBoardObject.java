package it.unibo.pps.e2;

public abstract class AbstractBoardObject implements BoardObject {

    protected Pair<Integer, Integer> boardObject;

    public AbstractBoardObject(int row, int col) {
        this.boardObject = new Pair<>(row, col);
    }

    public AbstractBoardObject(Pair<Integer, Integer> boardObject) {
        this.boardObject = boardObject;
    }

    @Override
    public int getRow() {
        return this.boardObject.getX();
    }

    @Override
    public int getCol() {
        return this.boardObject.getY();
    }

    @Override
    public boolean isAt(final int row, final int col) {
        // return boardObject.getX() == row && boardObject.getY() == col; Forse così è meno opaco
        // ma il return sotto mi sembra più elegante
        return boardObject.equals(new Pair<>(row, col));
    }
}
