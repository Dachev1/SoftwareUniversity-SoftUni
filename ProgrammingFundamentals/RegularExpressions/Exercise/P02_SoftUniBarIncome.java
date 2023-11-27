package ProgrammingFundamentals.RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$");
        double totalIncome = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end of shift")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double spendMoney = price * count;
                System.out.printf("%s: %s - %.2f\n", name, product, spendMoney);
                totalIncome += spendMoney;
            }
        }

        System.out.printf("Total income: %.2f\n", totalIncome);
    }
}
