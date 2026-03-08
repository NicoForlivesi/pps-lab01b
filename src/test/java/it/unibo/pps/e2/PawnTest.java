package it.unibo.pps.e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest extends AbstractBoardObjectTest {

    private static final int INITIAL_ROW = 1;
    private static final int INITIAL_COL = 1;

    @Override
    protected BoardObject createObject(int row, int col) {
        return new PawnImpl(INITIAL_ROW, INITIAL_COL);
    }

    @Override
    protected int initialRow() {
        return INITIAL_ROW;
    }

    @Override
    protected int initialCol() {
        return INITIAL_COL;
    }
}
