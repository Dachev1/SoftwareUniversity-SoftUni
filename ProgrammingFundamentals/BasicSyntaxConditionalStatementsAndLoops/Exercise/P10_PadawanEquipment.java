package Exercise_September_15;

import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double pricePerSaber = Double.parseDouble(scanner.nextLine());
        double pricePerRobe = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        double totalPriceForSabers = Math.ceil((students * 1.1)) * pricePerSaber;
        double totalPriceForRobes = students * pricePerRobe;
        double totalPriceForBelts = (students - students / 6) * pricePerBelt;

        double totalPrice = totalPriceForSabers + totalPriceForRobes + totalPriceForBelts;

        if (totalPrice <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(budget - totalPrice));
        }
    }
}

