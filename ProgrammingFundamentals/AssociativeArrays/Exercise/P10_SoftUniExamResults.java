package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> examResults = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> submissions = new LinkedHashMap<>();
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("exam finished")) {
                break;
            }


            String[] data = line.split("-");
            String username = data[0];

            if (line.contains("banned")) {
                examResults.remove(username);
                continue;
            }

            int points = Integer.parseInt(data[2]);

            examResults.putIfAbsent(username, points);

            if (examResults.containsKey(username)) {
                if (points > examResults.get(username)) {
                    examResults.put(username, points);
                }
            }

            String language = data[1];
            submissions.putIfAbsent(language, 0);
            if (submissions.containsKey(language)) {
                submissions.put(language, submissions.get(language) + 1);
            }
        }

        System.out.println("Results:");
        examResults.forEach((k, v) -> {
            System.out.printf("%s | %d\n", k, v);
        });

        System.out.println("Submissions:");
        submissions.forEach((k, v) -> {
            System.out.printf("%s - %d\n", k, v);
        });
    }
}
