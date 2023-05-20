package com.coolcode;

import java.util.HashMap;

public class Board {

    private int size;
    private Pawn[][] fields;
    private static final String whiteSymbol = "\u2659";
    private static final String blackSymbol = "\u265F";


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
                    fields[row][col] = new Pawn(row, col, blackSymbol);
                    blackPawns--;
                }
            }
        }
        for (int row = size - nextColum; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    fields[row][col] = new Pawn(row, col, whiteSymbol);
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
                    System.out.print(pawn.getSymbol());

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



    public boolean isPawnOnFields(String currentPosition){
        Coordinates coordinates = Util.crateCoordinate(currentPosition,size);
        Pawn pawn = getFieldByCoordinate(coordinates);
        if (pawn != null){
            return true;
        }
        else {return false;}
    }

    public void movePawn(String curentPosition, String targetPosition) {
        Coordinates curentCoordinates = Util.crateCoordinate(curentPosition,size);
        Coordinates targetCoordinates = Util.crateCoordinate(targetPosition,size);

        Pawn pawn = getFieldByCoordinate(curentCoordinates);
        if (pawn.validateMove(targetCoordinates)) {
            pawn.setPosition(targetCoordinates);
            setFieldByCoordinate(pawn, targetCoordinates);
            removePawn(curentCoordinates);
        }
        else {
            System.out.println("Check rules!!! ");
        }
    }

    public void removePawn(Coordinates coordinates) {
        setFieldByCoordinate(null, coordinates);
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public Pawn getFieldByCoordinate(Coordinates coordinates) {
        return fields[coordinates.getX()][coordinates.getY()];
    }

    public void setFieldByCoordinate(Pawn pawn, Coordinates coordinates) {
        this.fields[coordinates.getX()][coordinates.getY()] = pawn;
    }

    // check if there is pawn with specific color
    private boolean isSymbolInFields(String symbol) {
        for (Pawn[] row : fields) {
            for (Pawn pawn : row) {
                if (pawn.getSymbol() == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIfWhitePawnsExists() {
        return isSymbolInFields(whiteSymbol);
    }

    private boolean checkIfBlackPawnsExist() {
        return isSymbolInFields(blackSymbol);
    }

    private boolean checkWinner() {
        if (!checkIfBlackPawnsExist() || !checkIfWhitePawnsExists()) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (checkWinner()) {
            if (checkIfWhitePawnsExists()) {
                return whiteSymbol;
            }
        } return blackSymbol;
    }
}
