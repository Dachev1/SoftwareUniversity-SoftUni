package ProgrammingFundamentals.FinalExamPractise.Exam5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int coolThreshold = getCoolThreshold(text);
        List<String> emojis = extractEmojis(text);

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojis.size());

        for (String emoji : emojis) {
            int coolPoints = 0;

            for (char el : emoji.toCharArray()) {
                if (Character.isAlphabetic(el)) {
                    coolPoints += el;
                }
            }

            if (coolPoints > coolThreshold) {
                System.out.println(emoji);
            }
        }
    }

    private static List<String> extractEmojis(String text) {
        Pattern pattern = Pattern.compile("(::|\\*\\*)([A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> emojis = new ArrayList<>();
        while (matcher.find()) {
            String emoji = matcher.group();
            emojis.add(emoji);
        }

        return emojis;
    }

    private static int getCoolThreshold(String text) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);

        int sum = 1;
        while (matcher.find()) {
            String digit = matcher.group();
            sum *= Integer.parseInt(digit);

        }

        return sum;
    }
}
