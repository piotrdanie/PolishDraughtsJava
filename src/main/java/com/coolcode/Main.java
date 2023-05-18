package com.coolcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
//        int size = 10;
        Board board = new Board(size);
//        int i = 0;
//        while ( i == 10){
        board.displayBoard();
        System.out.print("Enter Pawn position: ");
        String curentPosition = scanner.next();
        System.out.print("Enter target position: ");
        String targetPosition = scanner.next();
        board.movePawn(curentPosition,targetPosition);
        board.displayBoard();
//        i++;
//        }
        scanner.close();
    }
}



//        // TODO: get user input and check it try except
//
//        Board board2 = new Board(17);
//
//        System.out.println(board2.getSize());
//
//        board2.displayBoard();
//
//    }
//}