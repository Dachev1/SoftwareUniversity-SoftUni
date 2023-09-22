package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P01_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fee = Integer.parseInt(scanner.nextLine());

        double sneakers = fee * 0.6;
        double outfit = sneakers * 0.8;
        double ball = outfit * 1 / 4;
        double accessories = ball * 1/ 5;

        double sum = fee + sneakers + outfit + ball + accessories;

        System.out.printf("%.2f", sum);
    }
}
