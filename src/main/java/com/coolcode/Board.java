package com.coolcode;

public class Board {

    private int size;
    private Pawn[][] fields;



    public Board(int size) {
        this.size = size;
        this.fields = new Pawn[this.size][this.size];
        placePawns(this.size);
    }

    public int getSize() {
        return size;
    }

    private void placePawns(int size) {
        int blackPawns = (size * size) / 5;
        System.out.println("blackPawns: " + blackPawns);
        int whitePawns = (size * size) / 5;
        int nextColum = (int) ((int) whitePawns / (size / 2.0));
        System.out.println("pawns: " + whitePawns + " nextcolumn: " + nextColum);
        for (int row = 0; row < nextColum; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && blackPawns > 0) {
                    fields[row][col] = new Pawn("black", "b");
                    blackPawns--;
                }
            }
        }
        for (int row = size - nextColum; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    fields[row][col] = new Pawn("white", "w");
                    whitePawns--;
                }
            }
        }
    }

    public void displayBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Pawn pawn = fields[row][col];
                if (pawn != null) {
                    System.out.print(pawn.getSymbol() + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}

