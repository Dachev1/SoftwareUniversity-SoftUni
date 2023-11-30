package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P06_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> studentsInformation = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsInformation.putIfAbsent(student, new ArrayList<>());
            studentsInformation.get(student).add(grade);
        }

        studentsInformation.forEach((k, v) -> {
            double avgGrade = 0;
            for (double grade : v) {
                avgGrade += grade;
            }

            avgGrade /= v.size();
            if (avgGrade >= 4.50) {
                System.out.printf("%s -> %.2f\n", k, avgGrade);
            }
        });
    }
}
