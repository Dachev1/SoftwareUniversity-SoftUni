package Exercise_September_15;

import java.util.Scanner;

public class P09_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOrders = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        for (int i = 1; i <= countOrders ; i++) {
           double pricePerCapsule = Double.parseDouble(scanner.nextLine());
           int days = Integer.parseInt(scanner.nextLine());
           int countCapsules = Integer.parseInt(scanner.nextLine());

           double price = ((days * countCapsules) * pricePerCapsule);
           totalPrice += price;

            System.out.printf("The price for the coffee is: $%.2f\n", price);
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
