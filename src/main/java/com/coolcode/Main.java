package com.coolcode;

import com.coolcode.model.Game;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
<<<<<<< HEAD
        Game game = new Game();
        game.start();
=======
=======
>>>>>>> parent of 27bd548 (prawie koniec)
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
<<<<<<< HEAD
>>>>>>> parent of 27bd548 (prawie koniec)
=======
>>>>>>> parent of 27bd548 (prawie koniec)
    }
}