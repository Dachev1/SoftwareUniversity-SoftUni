package ProgrammingFundamentals.FinalExamPractise.Exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<location>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> locationList = new ArrayList<>();

        int points = 0;
        while (matcher.find()) {
            String location = matcher.group("location");
            locationList.add(location);
            points += location.length();
        }

        System.out.print("Destinations: ");
        System.out.print(String.join(", ", locationList));
        System.out.println();
        System.out.println("Travel Points: " + points);
    }
}
