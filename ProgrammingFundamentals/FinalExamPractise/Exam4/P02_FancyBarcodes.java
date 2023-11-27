package ProgrammingFundamentals.FinalExamPractise.Exam4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String inputText = scanner.nextLine();

            Pattern pattern = Pattern.compile("(@#{1,})(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#{1,})");
            Matcher matcher = pattern.matcher(inputText);

            boolean haventMatch = true;
            haventMatch = findProductGroup(matcher, haventMatch);

            if (haventMatch) {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static boolean findProductGroup(Matcher matcher, boolean haventMatch) {
        while (matcher.find()) {
            String barcode = matcher.group("barcode");
            haventMatch = false;

            String productGroup = "";
            for (char el : barcode.toCharArray()) {
                if (Character.isDigit(el)) {
                    productGroup += el;
                }
            }

            if (productGroup.isEmpty()) {
                System.out.println("Product group: 00");
            } else {
                System.out.println("Product group: " + productGroup);
            }
        }
        return haventMatch;
    }
}
