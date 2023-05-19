package com.coolcode;

import java.util.Scanner;

public class Game {

    Scanner scanner;
    Board board;
    boolean gameOver;

    public Game() {
        scanner = new Scanner(System.in);
        gameOver = false;
    }

    public void start() {
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
        board = new Board(size);
        board.displayBoard();

        while (!gameOver) {
            playRound();
        };
    }


    private void playRound() {

        System.out.print("Enter Pawn position: ");
        String curentPosition = scanner.next();
        System.out.print("Enter target position: ");
        String targetPosition = scanner.next();

        Coordinates curentCoordinates = Util.crateCoordinate(curentPosition,board.getSize());
        Coordinates targetCoordinates = Util.crateCoordinate(targetPosition,board.getSize());

        Pawn pawn = checkMove(curentCoordinates, targetCoordinates);
        if (pawn != null) {
            tryToMakeMove(pawn);
        }
    }

    private Pawn checkMove(Coordinates currentCoordinates, Coordinates targetCoordinates) {
        boolean isPawn = board.isPanwOnFields(currentCoordinates)
                && !board.isPanwOnFields(targetCoordinates);
        if (isPawn) {
            Pawn pawn = board.getPawn(currentCoordinates);
            return pawn;
        }
        return null;
    }

    private void tryToMakeMove(Pawn pawn) {
        // TODO: make move;

    }

    private boolean checkForWinner() {
        // TODO: if player wins then return true else return false;`
        // trzeba by było jakoś zliczać pionki jednego i drugiego koloru czy jedna z tych grup jest równa zero
        // jeśli tak to gracz z przeciwnymi pionkami wygrał
        return true;
    }

}
