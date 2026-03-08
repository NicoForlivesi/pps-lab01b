package it.unibo.pps.e2;

public interface Board {

    int getSize();

    void moveKnight(int row, int col);

    Pair <Integer, Integer> getKnightPosition();

    Pair <Integer, Integer> getPawnPosition();
}
