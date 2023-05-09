package com.coolcode;

public class Pawn {

    private String color;
    private String symbol;
    private Coordinates position;

    public Pawn(String color, String symbol, int row, int col) {
        this.color = color;
        this.symbol = symbol;
        this.position = new Coordinates();
        this.position.x = row;
        this.position.y = col;
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getXYPosition() {
        Coordinates position = getPosition();
        int positionX = position.getX();
        int positionY = position.getY();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(positionX);
        stringBuilder.append("|");
        stringBuilder.append(positionY);

        return stringBuilder.toString();
    }

    private Coordinates getPosition() {
        return position;
    }
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
