package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    private static final int INITIAL_ROW = 4;
    private static final int INITIAL_COL = 2;
    private static final int NEXT_ROW = 3;
    private static final int NEXT_COL = 0;
    private static final int FORBIDDEN_ROW = 1;

    private KnightImpl knight;

    @BeforeEach
    public void init() {
        this.knight = new KnightImpl(INITIAL_ROW, INITIAL_COL);
    }

    @Test
    public void testKnightInitialPos() {
        assertTrue(knight.isAt(INITIAL_ROW, INITIAL_COL));
    }

    @Test
    public void testKnightCanMove() {
        knight.moveTo(NEXT_ROW, NEXT_COL);
        assertTrue(knight.isAt(NEXT_ROW, NEXT_COL));
    }

    @Test
    public void testKnightForbiddenMovement() {
        knight.moveTo(FORBIDDEN_ROW, NEXT_COL);
        assertFalse(knight.isAt(FORBIDDEN_ROW, NEXT_COL));
    }

}
