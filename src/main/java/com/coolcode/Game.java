package com.coolcode;

import java.util.Scanner;

public class Game {

    private View view;
    private Board board;
    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 20;


    public Game() {
        view = new View();
        int size = view.getBoardSize(MIN_SIZE, MAX_SIZE, "Enter board size.");
        board = new Board(size);

    }

    public void twoPlayersMode() {

        board.displayBoard();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            // get user current coordinates
            System.out.print("Enter Pawn position: ");
            String curentPosition = scanner.next();
            Coordinates currentCoordinates = Util.crateCoordinate(curentPosition, board.getSize());

            // get user target coordinates
            System.out.print("Enter target position: ");
            String targetPosition = scanner.next();
            Coordinates targetCoordinates = Util.crateCoordinate(targetPosition, board.getSize());

            // validate the coordinates
            boolean isPawn = board.isPawnOnFields(currentCoordinates)
                    && !board.isPawnOnFields(targetCoordinates);
            if (isPawn) {
                board.movePawn(currentCoordinates, targetCoordinates);
                board.displayBoard();
            }

            // check for winner in the match
            if (board.checkWinner()) {
                String winnerSymbol = board.getWinner();
                System.out.println("The winner of the match is " + winnerSymbol);
                break;
            }

        }

        scanner.close();
    }
}
