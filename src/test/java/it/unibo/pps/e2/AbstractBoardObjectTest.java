package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractBoardObjectTest {

    protected BoardObject object;

    protected abstract BoardObject createObject(int row, int col);
    protected abstract int initialRow();
    protected abstract int initialCol();

    @BeforeEach
    void init() {
        this.object = createObject(initialRow(), initialCol());
    }

    @Test
    public void testGetRow() {
        assertEquals(initialRow(), object.getRow());
    }

    @Test
    public void testGetCol() {
        assertEquals(initialCol(), object.getCol());
    }

    @Test
    public void testObjectInitialPos() {
        assertTrue(object.isAt(initialRow(), initialCol()));
    }
}
