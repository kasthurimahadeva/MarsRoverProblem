package Model;

import java.util.Arrays;
import java.util.List;

public class Plateau {
    private int width;
    private int height;
    private String[][] grid;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
        initailizeGrid();
    }

    private void initailizeGrid() {
        grid = new String[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                grid[row][column] = "* ";
            }
        }
    }

    public boolean isValid(Position position) {
        return position.getxCoordinate() <= this.width && position.getyCoordinate() <= this.height;
    }

    public void drawPlateau(List<Rover> rovers) {
        String[][] plateauCopy = grid.clone();
        for (Rover rover :
                rovers) {
            Position position = rover.getCurrentPosition();
            plateauCopy[this.height - 1 - position.getyCoordinate()][position.getxCoordinate()] = "R" + rover.getId() + "-" + rover.getCurrentPosition().getOrientation();
        }

        for (String[] row : plateauCopy) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
