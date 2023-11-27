package ProgrammingFundamentals.RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");


        for (String demonName : demonNames) {
            int health = getDemonsHealth(demonName);
            double damage = getDemonsDamage(demonName);

            System.out.printf("%s - %d health, %.2f damage\n", demonName, health, damage);
        }


    }

    private static double getDemonsDamage(String demonNames) {
        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(demonNames);

        double damage = 0;
        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        for (char chr : demonNames.toCharArray()) {
            if (chr == '*') {
                damage *= 2;
            } else if (chr == '/') {
                damage /= 2;
            }
        }

        return damage;
    }

    private static int getDemonsHealth(String demonName) {
        int health = 0;

        Pattern pattern = Pattern.compile("[^\\+\\-\\*\\/0-9\\.]");
        Matcher matcher = pattern.matcher(demonName);
        while (matcher.find()) {
            health += (int) matcher.group().charAt(0);
        }

        return health;
    }
}
