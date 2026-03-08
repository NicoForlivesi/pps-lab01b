package it.unibo.pps.e2;

import java.util.Random;

public class BoardImpl implements Board {

    private final int size;
    private KnightImpl knight;
    private PawnImpl pawn;
    private final Random random = new Random();

    public BoardImpl(int size) {
        this.size = size;
        this.pawn = new PawnImpl(randomEmptyPosition());
        this.knight = new KnightImpl(randomEmptyPosition());
    }

    public BoardImpl(int size, KnightImpl knight, PawnImpl pawn) {
        this(size);
        if(validInit(knight, pawn)) {
            this.knight = knight;
            this.pawn = pawn;
        } else { throw new IllegalStateException(); }
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    private boolean validInit(KnightImpl knight, PawnImpl pawn) {
        return (knight.getRow() < size && knight.getCol() < size &&
                pawn.getRow() < size && pawn.getCol() < size &&
                knight.getRow() != pawn.getRow() && knight.getCol() != pawn.getCol());
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void moveKnight(int row, int col) {
        knight.moveTo(row, col);
    }

    public final Pair <Integer, Integer> getKnightPosition() {
        return new Pair<>(knight.getRow(), knight.getCol());
    }

    public final Pair <Integer, Integer> getPawnPosition() {
        return new Pair<>(pawn.getRow(), pawn.getCol());
    }
}
