package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P04_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityOfHall = Integer.parseInt(scanner.nextLine());;
        String peopleComing = scanner.nextLine();
        int seats = 0;
        int income = 0;

        while (!peopleComing.equals("Movie time!")) {
            int currentPeople = Integer.parseInt(peopleComing);
            seats += currentPeople;

            if (seats > capacityOfHall) {
                System.out.println("The cinema is full.");
                break;
            }

            income += currentPeople * 5;

            if (currentPeople % 3 == 0) {
                income -= 5;
            }
            peopleComing = scanner.nextLine();
        }

        if (capacityOfHall >= seats) {
            System.out.printf("There are %d seats left in the cinema.%n", capacityOfHall - seats);
        }

        System.out.printf("Cinema income - %d lv.", income);
    }
}
