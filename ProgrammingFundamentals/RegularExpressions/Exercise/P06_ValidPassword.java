package ProgrammingFundamentals.RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_ValidPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("_\\.+([A-Z](?<partOfPassword>[A-Za-z0-9]{4,})[A-Z])_\\.+");

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                String groupType = getGroup(matcher.group("partOfPassword"));
                System.out.printf("Group: %s\n", groupType);
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }

    private static String getGroup(String partOfPassword) {
        StringBuilder sb = new StringBuilder();

        for (char chr : partOfPassword.toCharArray()) {
            if (Character.isDigit(chr)) {
                sb.append(chr);
            }
        }

        if (sb.length() == 0) {
            return "default";
        } else {
            return sb.toString();
        }
    }
}
