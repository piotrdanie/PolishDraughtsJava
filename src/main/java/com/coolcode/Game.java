package com.coolcode;

import java.util.Scanner;

public class Game {

    public static void main() {

        // get size of the board from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();

        // prepare the game
        Board board = new Board(size);
        board.displayBoard();

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
