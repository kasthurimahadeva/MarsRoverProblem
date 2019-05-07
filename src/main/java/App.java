import Model.Constants;
import Model.Plateau;
import Model.Position;
import Model.Rover;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Rover> rovers = parseInput();
        printRoverInfo(rovers);
        moveRoversSequentially(rovers);
        printRoverInfo(rovers);
        writeOutputToFile(rovers);
    }

    private static void writeOutputToFile(List<Rover> rovers) {
        StringBuilder output = new StringBuilder();
        for (Rover rover : rovers) {
            output.append(rover.getCurrentPosition().getxCoordinate())
                    .append(" ")
                    .append(rover.getCurrentPosition().getyCoordinate())
                    .append(" ")
                    .append(rover.getCurrentPosition().getOrientation())
                    .append("\n");
        }
        Path path = Paths.get("output.txt");
        byte[] strToBytes = output.toString().getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            System.out.println("Unable to write data to output.txt");
            e.printStackTrace();
        }
        System.out.println("Successfully wrote output to output.txt");
    }

    private static List<Rover> parseInput() {
        List<String> lines = getLinesFromFile("input.txt");
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

    private static List<String> getLinesFromFile(String fileName) {
        List<String> lines = null;
        try {
            File jarFile = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String inputFilePath = jarFile.getParent() + File.separator + fileName;
            File inputFile = new File(inputFilePath);
            lines = Files.readAllLines(Paths.get(inputFile.toURI()));

        } catch (Exception e) {
            System.out.println("Unable to read input.txt, existing");
            e.printStackTrace();
            System.exit(0);
        }
        return lines;
    }
}
