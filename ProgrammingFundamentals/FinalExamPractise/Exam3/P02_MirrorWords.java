package ProgrammingFundamentals.FinalExamPractise.Exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<firstWord>[A-Za-z]{3,}+)\\1\\1(?<secondWord>[A-Za-z]{3,}+)\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> mirroredWords = new ArrayList<>();
        int matcherCount = 0;

        while (matcher.find()) {
            matcherCount++;

            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");

            StringBuilder reversedWord = new StringBuilder(firstWord);
            reversedWord.reverse();

            if (reversedWord.toString().equals(secondWord)) {
                mirroredWords.add(firstWord + " <=> " + secondWord);
            }
        }

       if (matcherCount != 0) {
           System.out.println(matcherCount +" word pairs found!");
           if (!mirroredWords.isEmpty()) {
               System.out.println("The mirror words are:");
               System.out.println(String.join(", ", mirroredWords));
           } else {
               System.out.println("No mirror words!");
           }
       } else {
           System.out.println("No word pairs found!");
           System.out.println("No mirror words!");
       }
    }
}
