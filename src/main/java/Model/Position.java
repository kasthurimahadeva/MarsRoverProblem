package Model;

import Model.Constants.Orientation;

public class Position {
    private int xCoordinate;
    private int yCoordinate;
    private Orientation orientation;

    public Position(int xCoordinate, int yCoordinate, Orientation orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void incrementXCoordinate() {
        this.xCoordinate++;
    }

    public void decrementXCoordinate() {
        this.xCoordinate--;
    }

    public void incrementYCoordinate() {
        this.yCoordinate++;
    }

    public void decrementYCoordinate() {
        this.yCoordinate--;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Position{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", orientation=" + orientation +
                '}';
    }
}

