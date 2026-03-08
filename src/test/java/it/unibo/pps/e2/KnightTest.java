package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends AbstractBoardObjectTest {

    private static final int INITIAL_ROW = 4;
    private static final int INITIAL_COL = 2;
    private static final int NEXT_ROW = 3;
    private static final int NEXT_COL = 0;
    private static final int FORBIDDEN_ROW = 1;

    @Override
    protected BoardObject createObject(int row, int col) {
        return new KnightImpl(INITIAL_ROW, INITIAL_COL);
    }

    @Override
    protected int initialRow() {
        return INITIAL_ROW;
    }

    @Override
    protected int initialCol() {
        return INITIAL_COL;
    }

    @Test
    public void testKnightCanMove() {
        KnightImpl knight = createKnight();
        knight.moveTo(NEXT_ROW, NEXT_COL);
        assertTrue(knight.isAt(NEXT_ROW, NEXT_COL));
    }

    @Test
    public void testKnightForbiddenMovement() {
        KnightImpl knight = createKnight();
        knight.moveTo(FORBIDDEN_ROW, NEXT_COL);
        assertFalse(knight.isAt(FORBIDDEN_ROW, NEXT_COL));
    }

    private KnightImpl createKnight() {
        return new KnightImpl(INITIAL_ROW, INITIAL_COL);
    }
}
