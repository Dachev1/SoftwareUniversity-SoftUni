package ProgrammingFundamentals.RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phoneNumbers = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(phoneNumbers);

        List<String> validNumbers = new ArrayList<>();

        while (matcher.find()) {
            validNumbers.add(matcher.group());
        }

        System.out.println(String.join(", ", validNumbers));
    }
}
