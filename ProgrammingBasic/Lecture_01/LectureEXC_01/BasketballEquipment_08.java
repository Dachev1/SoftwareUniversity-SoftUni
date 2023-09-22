package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class BasketballEquipment_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int yearFee = Integer.parseInt(scanner.nextLine());

        double basketballSneakers = yearFee - (yearFee * 0.40);
        double basketballOutfit = basketballSneakers - (basketballSneakers * 0.20);
        double ball = basketballOutfit / 4;
        double accessories = ball / 5;

        double totalPrice = yearFee + basketballSneakers + basketballOutfit + ball + accessories;

        System.out.println(totalPrice);
    }
}
