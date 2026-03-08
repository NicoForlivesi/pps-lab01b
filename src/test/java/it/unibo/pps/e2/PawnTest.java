package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {

    private static final int INITIAL_ROW = 1;
    private static final int INITIAL_COL = 1;

    private PawnImpl pawn;

    @BeforeEach
    public void init() {
        this.pawn = new PawnImpl(INITIAL_ROW, INITIAL_COL);
    }

    @Test
    public void testPawnInitialPos() {
        assertTrue(pawn.isAt(INITIAL_ROW, INITIAL_COL));
    }
}
