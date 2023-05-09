package com.coolcode;

public class Pawn {

    private final boolean isWhite;
    private String symbol;
    private final Coordinates position;

    public Pawn(int row, int col, boolean isWhite) {
        this.position = new Coordinates();
        this.position.x = row;
        this.position.y = col;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }


    public String getXYPosition() {
        Coordinates position = getPosition();
        int positionX = position.getX();
        int positionY = position.getY();

        String stringBuilder = positionX +
                "|" +
                positionY;

        return stringBuilder;
    }

    private Coordinates getPosition() {
        return position;
    }


    class Coordinates {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

