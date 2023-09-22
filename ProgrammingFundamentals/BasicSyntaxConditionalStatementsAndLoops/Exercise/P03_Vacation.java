package Exercise_September_15;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double pricePerPerson = 0;
        if (groupType.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                pricePerPerson = 8.45;
            } else if (dayOfWeek.equals("Saturday")) {
                pricePerPerson = 9.80;
            } else if (dayOfWeek.equals("Sunday")) {
                pricePerPerson = 10.46;
            }
        } else if (groupType.equals("Business")) {
            if (dayOfWeek.equals("Friday")) {
                pricePerPerson = 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                pricePerPerson = 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                pricePerPerson = 16;
            }
        } else if (groupType.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                pricePerPerson = 15;
            } else if (dayOfWeek.equals("Saturday")) {
                pricePerPerson = 20;
            } else if (dayOfWeek.equals("Sunday")) {
                pricePerPerson = 22.50;
            }
        }

        double totalPrice = people * pricePerPerson;

        if (groupType.equals("Students") && people >= 30) {
            totalPrice *= 0.85;
        } else if (groupType.equals("Business") && people >= 100) {
            int peopleStayForFree = people / 10;
            totalPrice -= peopleStayForFree * pricePerPerson;
        } else if (groupType.equals("Regular") && people >= 10 && people <= 20) {
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
