package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    private static final int A_SINGLE_ELEMENT = 1;
    private static final int KNIGHT_INITIAL_ROW = 4;
    private static final int KNIGHT_INITIAL_COL = 2;
    private static final int PAWN_INITIAL_ROW = 1;
    private static final int PAWN_INITIAL_COL = 1;
    private static final int OUT_OF_BOUND_ROW = SIZE + 1;
    private static final int OUT_OF_BOUND_COL = SIZE + 1;

    private LogicsImpl logic;
    private final HashMap<String, Integer> knightRowAtTime = new HashMap<>() {{
        put("t0", KNIGHT_INITIAL_ROW);
        put("t1", 3);
        put("t2", 1);
    }};
    private final HashMap<String, Integer> knightColAtTime = new HashMap<>() {{
        put("t0", KNIGHT_INITIAL_COL);
        put("t1", 0);
        put("t2", 1);
    }};

    @BeforeEach
    public void init() {
        this.logic = new LogicsImpl(
                SIZE,
                new Pair<>(KNIGHT_INITIAL_ROW, KNIGHT_INITIAL_COL),
                new Pair<>(PAWN_INITIAL_ROW, PAWN_INITIAL_COL)
        );
    }

    @Test
    public void testASingleKnightIsPresent() {
        int nKnight = 0;
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(logic.hasKnight(row, col)) { nKnight++; }
            }
        }
        assertEquals(A_SINGLE_ELEMENT, nKnight);
    }

    @Test
    public void testASinglePawnIsPresent() {
        int nPawn = 0;
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(logic.hasPawn(row, col)) { nPawn++; }
            }
        }
        assertEquals(A_SINGLE_ELEMENT, nPawn);
    }

    @Test
    public void testKnightInRightBox() {
        assertTrue(logic.hasKnight(KNIGHT_INITIAL_ROW, KNIGHT_INITIAL_COL));
    }

    @Test
    public void testPawnInRightBox() {
        assertTrue(logic.hasPawn(PAWN_INITIAL_ROW, PAWN_INITIAL_COL));
    }

    @Test
    public void testHit() {
        logic.hit(knightRowAtTime.get("t1"), knightColAtTime.get("t1"));
        assertTrue(logic.hasKnight(knightRowAtTime.get("t1"), knightColAtTime.get("t1")));
    }

    @Test
    public void testKnightMovementOutOfBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(OUT_OF_BOUND_ROW, OUT_OF_BOUND_COL));
    }

//    @Test
//    public void testForbiddenKnightMovement() {
//        // Tested by going directly from t0 (init pos) to t2 (final pos)
//        logic.hit(knightRowAtTime.get("t2"), knightColAtTime.get("t2"));
//        assertFalse(logic.hasKnight(knightRowAtTime.get("t2"), knightColAtTime.get("t2")));
//    } Already done in KnightTest

    @Test
    public void testWinCondition() {
        logic.hit(knightRowAtTime.get("t1"), knightColAtTime.get("t1"));
        assertTrue(logic.hit(knightRowAtTime.get("t2"), knightColAtTime.get("t2")));
    }
}
