package ProgrammingFundamentals.RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<furnitureName>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");
        List<String> purchasedFurniture = new ArrayList<>();
        double moneySpend = 0;

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Purchase")) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                purchasedFurniture.add(furnitureName);
                moneySpend += price * quantity;
            }
        }

        System.out.println("Bought furniture:");
        purchasedFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f\n", moneySpend);
    }
}
