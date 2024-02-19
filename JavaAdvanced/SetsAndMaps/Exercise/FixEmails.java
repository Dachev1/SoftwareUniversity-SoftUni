package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsData = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();

            if (!(email.endsWith(".us") || email.endsWith(".uk") || email.endsWith(".com"))) {
                emailsData.put(name, email);
            }
        }

        emailsData.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
