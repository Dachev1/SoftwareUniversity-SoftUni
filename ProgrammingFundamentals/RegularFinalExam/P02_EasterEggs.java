package ProgrammingFundamentals.RegularFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@|#]+)(?<eggColor>[a-z]{3,})([@|#]+)(\\W+)(?<amount>[0-9]+)(\\/)+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = matcher.group("eggColor");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!\n", amount, color);
        }

    }
}
