package com.coolcode.model;

public class Board {

    private int size;
    private Pawn[][] fields;


    public Board(int size) {
        this.size = size;
        this.fields = new Pawn[this.size][this.size];
    }

    public int getSize() {
        return size;
    }


    public boolean isPanwOnFields(Coordinates coordinates){
        Pawn pawn = getFieldFromCoordinates(coordinates);
        if (pawn != null){
            return true;
        }
        return false;
    }

    public void movePawn(Coordinates curentCoordinates, Coordinates targetCoordinates) {

        Pawn pawn = fields[curentCoordinates.getX()][curentCoordinates.getY()];
        if (pawn.validateMove(targetCoordinates)){;
        pawn.setPosition(targetCoordinates);

        fields[targetCoordinates.getX()][targetCoordinates.getY()] = pawn;
        removePawn(curentCoordinates);}
        else {
            System.out.println("Check rules!!! ");
        }
    }

    public void removePawn(Coordinates coordinates) {
        fields[coordinates.getX()][coordinates.getY()] = null;
        System.out.print(" ");
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public Pawn getFieldFromCoordinates(Coordinates coordinates) {
        return this.fields[coordinates.getX()][coordinates.getY()];
    }

    public void setFieldFromCoordinates(Pawn pawn, Coordinates coordinates) {
        this.fields[coordinates.getX()][coordinates.getY()] = pawn;
    }
}
