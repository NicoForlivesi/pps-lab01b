package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private static final int SIZE = 5;
    private static final KnightImpl knight = new KnightImpl(4, 2);
    private static final PawnImpl pawn = new PawnImpl(1, 1);

    private BoardImpl board;

    @BeforeEach
    public void init() {
        this.board = new BoardImpl(SIZE, knight, pawn);
    }

    @Test
    public void testGetSize() {
        assertEquals(SIZE, board.getSize());
    }
}
