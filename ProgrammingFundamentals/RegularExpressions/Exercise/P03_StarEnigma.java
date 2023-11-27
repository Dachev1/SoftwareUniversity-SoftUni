package ProgrammingFundamentals.RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("\\w*@(?<planetName>[A-Za-z]+)\\d?[^@:!\\->]*:(?<planetPopulation>[0-9]+)[^@:!\\->]*!(?<attackType>[A|D])![^@:!\\->]*->(?<soldierCount>[0-9]+)\\w*");
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets  = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            // decrypt a message
            int lettersCount = getLetterCount(message);
            StringBuilder sb = new StringBuilder();
            String decryptMessage = getDecryptMessage(message, sb, lettersCount);

            // after decrypt
            Matcher matcher = pattern.matcher(decryptMessage);


            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                char attackType = matcher.group("attackType").charAt(0);

                if (attackType == 'A') {
                    attackedPlanets.add(planetName);
                } else if (attackType == 'D') {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        // ordered by name alphabetically
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        if (!attackedPlanets.isEmpty()) {
            attackedPlanets.forEach(e -> System.out.printf("-> %s\n", e));
        }
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            destroyedPlanets.forEach(e -> System.out.printf("-> %s\n", e));
        }

    }

    private static String getDecryptMessage(String message, StringBuilder sb, int lettersCount) {
        for (char currentMessage : message.toCharArray()) {
            char chr = (char) (currentMessage - lettersCount);
            sb.append(chr);
        }

        return sb.toString();
    }

    private static int getLetterCount(String message) {
        int lettersCount = 0;
        for (char chr : message.toLowerCase().toCharArray()) {
            if (chr == 's' ||
                chr == 't' ||
                chr == 'a' ||
                chr == 'r') {
                lettersCount++;
            }
        }

        return  lettersCount;
    }
}
