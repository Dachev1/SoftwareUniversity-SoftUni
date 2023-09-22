package MoreExercises_01;

import java.util.Scanner;

public class P05_TrainingLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double h = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());

        h = h * 100; // превръщане в сатниметри
        w = w * 100; // превръщане в сантиметри
        w = w - 100; // изваждаме 100см за коридора

        //int rows = (int) (h / 120); // изчисляване на редовете
        //int desks = (int) (w / 70); // изчисляване на бюрата за всеки ред

        double rows = Math.floor(h / 120); // изчисляване на редовете
        double desks = Math.floor(w / 70); // изчисляване на бюрата за всеки ред


        // смятане на работните места като се изваждат 3 които се губят заради вратата и катедрата
        double seats = rows * desks - 3;

        System.out.println(seats);
    }
}