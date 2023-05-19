package com.coolcode;

import java.util.Scanner;

public class Game {

    Scanner scanner;
    Board board;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
        board = new Board(size);
        board.displayBoard();
        boolean isGameOver = false;
        while (!isGameOver) {
            playRound();
        };
    }


    private void playRound() {

        System.out.print("Enter Pawn position: ");
        String curentPosition = scanner.next();
        System.out.print("Enter target position: ");
        String targetPosition = scanner.next();
        boolean isPawn = board.isPanwOnFields(curentPosition)
                && !board.isPanwOnFields(targetPosition);
        if (isPawn) {
            board.movePawn(curentPosition, targetPosition);
            board.displayBoard();
        }

    }

    private Pawn checkMove(Coordinates currentCoordinates, Coordinates targetCoordinates) {
        return new Pawn(9, 9, true);
    }

    private void tryToMakeMove(Pawn pawn) {

    }

    private boolean checkForWinner() {
        return true;
    }

}
