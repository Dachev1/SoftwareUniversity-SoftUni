package ProgrammingFundamentals.Methods.Exercise.MoreExercises;

import java.util.Scanner;

public class P01_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfData = scanner.nextLine();

        switch (typeOfData) {
            case "int":
                int intNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(intNumber * 2);
                break;
            case "real":
                double doubleNumber = Double.parseDouble(scanner.nextLine());
                System.out.printf("%.2f", doubleNumber * 1.5);
                break;
            case "string":
                String text = scanner.nextLine();
                System.out.println("$" + text + "$");
                break;
            default:
                break;
        }
    }
}
