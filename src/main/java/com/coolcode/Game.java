package com.coolcode;

import java.util.Scanner;

public class Game {



    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
        Board board = new Board(size);
        board.displayBoard();
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.print("Enter Pawn position: ");
            String curentPosition = scanner.next();
            System.out.print("Enter target position: ");
            String targetPosition = scanner.next();

            boolean isPawn = board.isPawnOnFields(curentPosition)
                    && !board.isPawnOnFields(targetPosition);
            if (isPawn) {
                board.movePawn(curentPosition, targetPosition);
                board.displayBoard();
            }

            // @Piotr zobacz dodałem w boardzie metody
            board.getWinner();
        };
        scanner.close();
    }

    }
