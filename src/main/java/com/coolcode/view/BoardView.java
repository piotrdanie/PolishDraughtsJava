package com.coolcode.view;

import com.coolcode.model.Board;
import com.coolcode.model.Pawn;

public class BoardView {

    private final String squareShape = "\u25A1";

    public void displayBoard(Board board) {
        // print column labels
        System.out.print("    ");
        for (int col = 1; col <= board.getSize(); col++) {
            System.out.printf("%3d", col);
        }
        System.out.println();

        // print row labels and field contents
        for (int row = 0; row < board.getSize(); row++) {
            // print row label
            System.out.format("%4s", (char) ('A'  +  row));


            // print field contents
            for (int col = 0; col < board.getSize(); col++) {
                Pawn pawn = board.getFields()[row][col];
                if (pawn != null) {
                    System.out.format("%3s", pawn.getSymbol());
                } else if(col % 2 != 0 && row % 2 == 0) {
                    System.out.printf("%3s", squareShape);
                } else if (col % 2 == 0 && row % 2 != 0) {
                    System.out.printf("%3s", squareShape);
                } else {
                    System.out.printf("%3s", "  ");
                }
            }
            System.out.println();
        }
    }
}
