package Lecture_01;

import java.util.Scanner;

public class PetShop_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dogF = Integer.parseInt(scanner.nextLine());
        int catF = Integer.parseInt(scanner.nextLine());

        double sum = (dogF * 2.50) + (catF * 4);

        System.out.println(sum + " lv.");
    }
}
