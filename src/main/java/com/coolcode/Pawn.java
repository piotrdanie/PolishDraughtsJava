package com.coolcode;

public class Pawn {

    public static int Coordinates;
    private final boolean isWhite;
    private String symbol;
    private Coordinates position;

    public Pawn(int row, int col, boolean isWhite) {
        this.position = new Coordinates(row,col);
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

    public Coordinates getPosition() {
        return position;
    }


    public void setPosition(Coordinates targetPosition) {
        this.position = targetPosition;
    }

}


