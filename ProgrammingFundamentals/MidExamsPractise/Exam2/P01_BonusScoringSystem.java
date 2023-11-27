package ProgrammingFundamentals.MidExamsPractise.Exam2;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int attendedLectures = 0;
        for (int i = 0; i < countStudents; i++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());

           double currentBonus = (studentAttendances * 1.0 / lecturesCount) * (5 + bonus);


            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                attendedLectures = studentAttendances;
            }
        }


        System.out.printf("Max Bonus: %.0f.\n" , Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.\n" , attendedLectures);
        }
    }

