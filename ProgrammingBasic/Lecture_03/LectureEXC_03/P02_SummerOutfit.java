package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P02_SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();

        String outfit = "";
        String shoes = "";
        if (partOfDay.equals("Morning")) {
            if (degrees <= 18) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (degrees <= 24) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else  {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        } else if (partOfDay.equals("Afternoon")) {
            if (degrees <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degrees <= 24) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else  {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        } else if (partOfDay.equals("Evening")) {
            outfit = "Shirt";
            shoes = "Moccasins";
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees , outfit , shoes);
    }
}
