package com.coolcode;

import java.util.Scanner;

public class Board {

    private int size;
    private Pawn[][] fields;


    public Board(int size) {
        this.size = size;
        this.fields = new Pawn[this.size][this.size];
        placePawns(this.size);
    }

//    public int getSize() {
//        return size;
//    }

    private void placePawns(int size) {
        int blackPawns = (size * size) / 5;
        System.out.println("blackPawns: " + blackPawns);
        int whitePawns = (size * size) / 5;
        int nextColum = (int) ((int) whitePawns / (size / 2.0));
        System.out.println("pawns: " + whitePawns + " nextcolumn: " + nextColum);
        for (int row = 0; row < nextColum; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && blackPawns > 0) {
                    fields[row][col] = new Pawn(row, col,false);
                    blackPawns--;
                }
            }
        }
        for (int row = size - nextColum; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    fields[row][col] = new Pawn(row, col, true);
                    whitePawns--;
                }
            }
        }
    }

//    public void displayBoard() {
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                Pawn pawn = fields[row][col];
//                if (pawn != null) {
//                    System.out.print(pawn.getXYPosition() + " ");
//                } else {
//                    System.out.print("-" + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
//    public void displayBoard() {
//        // print column labels
//        System.out.print("  ");
//        for (int col = 1; col <= size; col++) {
//            System.out.print(col + " ");
//        }
//        System.out.println();
//
//        // print row labels and field contents
//        for (int row = 0; row < size; row++) {
//            // print row label
//            System.out.print((char) ('A' + row) + " ");
//
//            // print field contents
//            for (int col = 0; col < size; col++) {
//                Pawn pawn = fields[row][col];
//                if (pawn != null) {
//                    System.out.print(pawn.getXYPosition() + " ");
//                } else {
//                    System.out.print("- ");
//                }
//            }
//            System.out.println();
//        }
//    }
    public void displayBoard() {
    // print column labels
    System.out.print("  ");
    for (int col = 1; col <= size; col++) {
        System.out.print(col + " ");
    }
    System.out.println();

    // print row labels and field contents
    for (int row = 0; row < size; row++) {
        // print row label
        System.out.print((char) ('A' + row) + " ");


        // print field contents
        for (int col = 0; col < size; col++) {
            Pawn pawn = fields[row][col];
            if (pawn != null) {
                System.out.print(getEmojiPawn(pawn.isWhite()) + " ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}


    private String getEmojiPawn(boolean isWhite) {
        return isWhite ? "\u2659" : "\u265F";
    }


    public void movePawn(Pawn pawn, int row, int col) {

    }
}