package ProgrammingFundamentals.MidExamsPractise.Exam5;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int allEmployees = employee1 + employee2 + employee3;

        int hours = 0;
        while (studentsCount > 0) {
            hours++;
            if (hours % 4 == 0) {
                continue;
            }
            studentsCount -= allEmployees;
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
