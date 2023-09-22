package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P05_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tabs; i++) {
            String websiteName = scanner.nextLine();

            if (websiteName.equals("Facebook")) {
                salary -= 150;
            } else if (websiteName.equals("Instagram")) {
                salary -= 100;
            } else if (websiteName.equals("Reddit")) {
                salary -= 50;
            }
            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }

        if (salary > 0) {
            System.out.println(salary);
        }
    }
}
