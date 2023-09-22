package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P03_TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String town = scanner.nextLine();
        String packetType = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (town.equals("Bansko") || town.equals("Borovets")) {
            if (packetType.equals("withEquipment")) {
                price += 100;

                if (vip.equals("yes")) {
                    price *= 0.90;
                }
            } else  if (packetType.equals("noEquipment")) {
                price += 80;

                if (vip.equals("yes")) {
                    price *= 0.95;
                }
            }
        } else if (town.equals("Varna") || town.equals("Burgas")) {
            if (packetType.equals("withBreakfast")) {
                price += 130;

                if (vip.equals("yes")) {
                    price *= 0.88;
                }
            } else  if (packetType.equals("noBreakfast")) {
                price += 100;

                if (vip.equals("yes")) {
                    price *= 0.93;
                }
            } else {
                System.out.println("Invalid input!");
                return;
            }


        } else {
            System.out.println("Invalid input!");
            return;
        }

        if (days > 7) {
            days -= 1;
        }

        price *= days;

        if (days < 1) {
            System.out.println("Days must be positive number!");
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", price);
        }
    }
}
