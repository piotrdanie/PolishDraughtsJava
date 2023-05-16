package com.coolcode;

import java.util.HashMap;

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
                    fields[row][col] = new Pawn(row, col, false);
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

//        public void displayBoard() {
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
        System.out.print(" ");
        for (int col = 1; col <= size; col++) {
            System.out.print(col);
        }
        System.out.println();

        // print row labels and field contents
        for (int row = 0; row < size; row++) {
            // print row label
            System.out.print((char) ('A' + row));


            // print field contents
            for (int col = 0; col < size; col++) {
                Pawn pawn = fields[row][col];
                if (pawn != null) {
                    System.out.print(getEmojiPawn(pawn.isWhite()));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    private String getEmojiPawn(boolean isWhite) {
        return isWhite ? "\u2659" : "\u265F";
    }


    public void movePawn(String curentPosition, String targetPosition) {
        int[] curent = convertCoordinateToArray(curentPosition);
        int[] target = convertCoordinateToArray(targetPosition);
        int curentRow = curent[0];
        int curentCol = curent[1];
        System.out.println("curentPosition " + curentRow +" "+ curentCol);

        int targetRow = target[0];
        int targetCol = target[1];
        System.out.println("targetPosition " + targetRow +" "+ targetCol);
        fields[targetRow][targetCol] = fields[curentRow][curentCol];
        removePawn(curentRow,curentCol);
    }


    public void removePawn(int row, int col) {
        fields[row][col] = null;
        System.out.print(" ");
    }

    public static int[] convertCoordinateToArray(String userInput) {
        int[] indices = new int[2];
        userInput = userInput.toUpperCase();
        String letter = userInput.substring(0, 1);
        int col = Integer.parseInt(userInput.substring(1))-1;
        int row = convertStringToInteger(letter);

//        System.out.println("row letter " + letter);
//        System.out.println("row number " + row);
//        System.out.println("col " + col);

        indices[0] = row;
        indices[1] = col;

        return indices;
    }

    public static int convertStringToInteger(String letter) {
        HashMap<String, Integer> columnsDict = new HashMap<>();

        for (int row = 0; row < 10; row++) {
            columnsDict.put(String.valueOf((char) ('A' + row)), row);
        }

        return columnsDict.get(String.valueOf(letter.charAt(0)));
    }

//    public static int convertStringToInteger(String letter) {
//        HashMap<String, Integer> columnsDict = new HashMap<>();
//        columnsDict.put("A", 1);
//        columnsDict.put("B", 1);
//        columnsDict.put("C", 2);
//        columnsDict.put("D", 3);
//        columnsDict.put("E", 4);
//        columnsDict.put("F", 5);
//        columnsDict.put("G", 6);
//        columnsDict.put("H", 7);
//        columnsDict.put("I", 8);
//        columnsDict.put("J", 9);
//
//        return columnsDict.get(String.valueOf(letter.charAt(0)));
//    }


    public Pawn[][] getFields() {
        return fields;
    }
}
