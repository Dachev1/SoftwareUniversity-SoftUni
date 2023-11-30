package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P04_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String command =  input[0];
            String username =  input[1];

            if (command.equals("register")) {
                String carNumber =  input[2];

                if (parking.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s\n", parking.get(username));
                } else {
                    System.out.printf("%s registered %s successfully\n", username, carNumber);
                    parking.put(username, carNumber);
                }
            } else if (command.equals("unregister")) {
                if (parking.containsKey(username)) {
                    System.out.printf("%s unregistered successfully\n", username);
                    parking.remove(username);
                } else {
                    System.out.printf("ERROR: user %s not found\n", username);
                }
            }
        }

        parking.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
