package Model;

import Model.Constants.Command;
import Model.Constants.Orientation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rover {
    private static int totalRoverCounts = 0;
    private final int id;
    private Position currentPosition;
    private List<String> pathHistory;
    private final Plateau plateau;
    private final char[] commandSequence;

    public Rover(Plateau plateau, Position currentPosition, char[] commandSequence) {
        this.plateau = plateau;
        this.commandSequence = commandSequence;
        this.id = totalRoverCounts++;
        this.currentPosition = currentPosition;
        pathHistory = new ArrayList<>();
    }

    /**
     * Modifies the current position of the rover based on the command received
     *
     * @param command the move command
     * @return the resultant @<code>Position</code>
     * @throws IllegalArgumentException thrown if move command is not any of `L`, `R` or `M`
     */
    public Position move(Command command) {
        pathHistory.add(currentPosition.toString());

        switch (command) {
            case L:
                turnLeft();
                break;
            case R:
                turnRight();
                break;
            case M:
                moveForward();
                break;
        }
        if (!plateau.isValid(currentPosition)) {
            System.out.println("Cannot move beyond plateau boundary, existing");
            System.exit(0);
        }
        return this.getCurrentPosition();
    }

    private void moveForward() {
        switch (this.currentPosition.getOrientation()) {
            case N:
                this.currentPosition.incrementYCoordinate();
                break;
            case E:
                this.currentPosition.incrementXCoordinate();
                break;
            case S:
                this.currentPosition.decrementYCoordinate();
                break;
            case W:
                this.currentPosition.decrementXCoordinate();
                break;
        }
    }

    private void turnRight() {
        int newOrientationIndex = this.currentPosition.getOrientation().getIndex() + 1;
        Orientation newOrientation = newOrientationIndex > Orientation.W.getIndex() ? Orientation.N : Orientation.resolveIndex(newOrientationIndex);
        currentPosition.setOrientation(newOrientation);
    }

    private void turnLeft() {
        int newOrientationIndex = this.currentPosition.getOrientation().getIndex() - 1;
        Orientation newOrientation = newOrientationIndex < Orientation.N.getIndex() ? Orientation.W : Orientation.resolveIndex(newOrientationIndex);
        currentPosition.setOrientation(newOrientation);
    }

    public int getId() {
        return id;
    }

    public Position getCurrentPosition() {
        // not returning currentPosition directly since there is a risk of modification
        return new Position(this.currentPosition.getxCoordinate(), this.currentPosition.getyCoordinate(), this.currentPosition.getOrientation());
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<String> getPathHistory() {
        return pathHistory;
    }

    public char[] getCommandSequence() {
        return commandSequence;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id=" + id +
                ", currentPosition=" + currentPosition +
                ", pathHistory=" + pathHistory +
                ", commandSequence=" + Arrays.toString(commandSequence) +
                '}';
    }
}
