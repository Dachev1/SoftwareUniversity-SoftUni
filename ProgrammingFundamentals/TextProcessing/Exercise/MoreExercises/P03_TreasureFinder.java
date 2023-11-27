package ProgrammingFundamentals.TextProcessing.Exercise.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the sequence of numbers
        int[] keys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // read text until I get "find"
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("find")) {
                break;
            }


            // loop from every chr from current string
            StringBuilder updatedText = new StringBuilder(line);
            int keyCounter = -1;
            for (int i = 0; i < updatedText.length(); i++) {
                char currentEl = updatedText.charAt(i);

                keyCounter++;
                if (keyCounter > keys.length - 1) {
                    keyCounter = 0;
                }

                int currentKey = keys[keyCounter];

                updatedText.setCharAt(i, (char) (currentEl - currentKey));
            }

            String treasure  = updatedText.toString();
            treasure = treasure.substring(treasure.indexOf("&") + 1);
            treasure = treasure.substring(0, treasure.indexOf("&"));

            String coordinates = updatedText.toString();
            coordinates = coordinates.substring(coordinates.indexOf("<") + 1);
            coordinates = coordinates.substring(0, coordinates.indexOf(">"));

            System.out.printf("Found %s at %s%n", treasure, coordinates);
        }
    }
}
