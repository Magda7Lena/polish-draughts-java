package com.company;

import javax.swing.*;

public class Pawn extends JButton {
    int xCoordinate;
    int yCoordinate;
    boolean isHighlight = false;
    //todo should contain initial color
    final Boolean isYellow;

    public Pawn(int xCoordinate, int yCoordinate, Boolean isYellow) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isYellow = isYellow;
    }

    public Boolean getIsYellow() {
        return isYellow;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setHighlight() {
        isHighlight = !isHighlight;
    }

    public boolean isHighlight() {
        return isHighlight;
    }
}
