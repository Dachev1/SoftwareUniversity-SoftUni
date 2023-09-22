package Lecture_05;

import java.util.Scanner;

public class P08_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name= scanner.nextLine();

        double sumGrades = 0;
        int counter = 1;
        int fail = 0;

        while (counter <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 4.00) {
                sumGrades += grade;
                counter++;
            } else {
                fail++;
                if (fail > 1) {
                    System.out.printf("%s has been excluded at %d grade", name, counter);
                    break;
                }
            }
        }

            if (counter >= 12 ) {
                System.out.printf("%s graduated. Average grade: %.2f", name, (sumGrades / 12));
            }
        }
    }

