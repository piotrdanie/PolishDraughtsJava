package com.coolcode.controller;

import com.coolcode.model.Board;
import com.coolcode.model.Pawn;
import com.coolcode.view.BoardView;
import com.coolcode.view.UserInput;

public class BoardController {

    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 20;
    private Board board;
    private BoardView boardView;
    private UserInput userInput;


    public BoardController() {
        int size = userInput.getNumberBetween(MIN_SIZE, MAX_SIZE);
        this.board = new Board(size);
        this.boardView = new BoardView();

    }

    private void placePawns() {
        int blackPawns = (board.getSize() * board.getSize()) / 5;
        System.out.println("blackPawns: " + blackPawns);
        int whitePawns = (board.getSize() * board.getSize()) / 5;
        int nextColum = (int) ((int) whitePawns / (board.getSize() / 2.0));
        System.out.println("pawns: " + whitePawns + " nextcolumn: " + nextColum);
        for (int row = 0; row < nextColum; row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if ((row + col) % 2 == 0 && blackPawns > 0) {
                    board.getFields()[row][col] = new Pawn(row, col, "\u265F");
                    blackPawns--;
                }
            }
        }
        for (int row = board.getSize() - nextColum; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if ((row + col) % 2 == 0 && whitePawns > 0) {
                    board.getFields()[row][col] = new Pawn(row, col, "\u2659");
                    whitePawns--;
                }
            }
        }
    }
}
