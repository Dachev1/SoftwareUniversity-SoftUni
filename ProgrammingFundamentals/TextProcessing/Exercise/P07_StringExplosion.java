package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        int totalPower = 0;
        for (int possition = 0; possition < text.length(); possition++) {
            char currentEl = text.charAt(possition);

            if (currentEl == '>') {
                int power = Integer.parseInt(text.charAt(possition + 1) + "");
                totalPower += power;
            }

            if (currentEl != '>' && totalPower > 0) {
                text.deleteCharAt(possition);
                totalPower--;
                possition--;
            }
        }

        System.out.println(text);
    }
}
