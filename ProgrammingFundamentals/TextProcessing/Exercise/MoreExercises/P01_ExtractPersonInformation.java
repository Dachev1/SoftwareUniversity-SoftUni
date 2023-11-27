package ProgrammingFundamentals.TextProcessing.Exercise.MoreExercises;

import java.util.Scanner;

public class P01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            String name = text;
            name = name.substring(name.indexOf("@") + 1);
            name = name.substring(0, name.indexOf("|"));

           String age = text;
            age = age.substring(age.indexOf("#") + 1);
            age = age.substring(0, age.indexOf("*"));

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
