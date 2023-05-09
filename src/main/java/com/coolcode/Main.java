package com.coolcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (between 10 and 20): ");
        int size = scanner.nextInt();
        Board board = new Board(size);
        board.displayBoard();
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