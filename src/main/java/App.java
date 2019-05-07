import Model.Constants;
import Model.Plateau;
import Model.Position;
import Model.Rover;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        List<Rover> rovers = parseInput();
        printRoverInfo(rovers);
        moveRoversSequentially(rovers);
        printRoverInfo(rovers);
    }

    private static List<Rover> parseInput() {
        List<String> lines = getLinesFromFile();
        Plateau plateau = constructPlateau(lines.get(0).trim());
        return constructRovers(lines, plateau);
    }

    private static List<Rover> constructRovers(List<String> lines, Plateau plateau) {
        List<Rover> rovers = new ArrayList<>();
        for (int i = 1; i < lines.size(); i += 2) {
            String[] data = lines.get(i).split(" ");
            Position position = new Position(Integer.parseInt(data[0].trim()),
                    Integer.parseInt(data[1].trim()),
                    Constants.Orientation.valueOf(data[2].toUpperCase()));
            char[] instructions = lines.get(i + 1).toCharArray();
            Rover rover = new Rover(plateau, position, instructions);
            rovers.add(rover);
        }
        return rovers;
    }

    private static void printRoverInfo(List<Rover> rovers) {
        for (Rover rover : rovers) {
            System.out.println(rover);
        }
        System.out.println();
    }

    private static Plateau constructPlateau(String plateauData) {
        String[] plateauDimension = plateauData.split(" ");
        return new Plateau(Integer.parseInt(plateauDimension[0].trim()), Integer.parseInt(plateauDimension[1].trim()));
    }

    private static void moveRoversSequentially(List<Rover> rovers) {
        for (Rover rover : rovers) {
            System.out.println("R" + rover.getId() + ": starting to move");
            System.out.println("R" + rover.getId() + ": initial position - " + rover.getCurrentPosition());
            for (char command : rover.getCommandSequence()) {
                System.out.println("R" + rover.getId() + ": command received - " + command);
                rover.move(Constants.Command.valueOf(Character.toString(command).toUpperCase()));

                System.out.println("R" + rover.getId() + ": after command - " + rover.getCurrentPosition() + "\n");
            }
            System.out.println();
        }
    }

    private static List<String> getLinesFromFile() {
        List<String> lines = null;
        try {
            ClassLoader classLoader = App.class.getClassLoader();
            lines = Files.readAllLines(Path.of(Objects.requireNonNull(classLoader.getResource("input.txt")).toURI()), StandardCharsets.UTF_8);

        } catch (Exception e) {
            System.out.println("Unable to read input.txt, existing");
            e.printStackTrace();
            System.exit(0);
        }
        return lines;
    }
}
