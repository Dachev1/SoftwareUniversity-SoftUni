package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.*;

public class P09_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> users = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Lumpawaroo")) {
                break;
            }

            if (input.contains("|")) {
                String[] data = input.split("\\s+\\|\\s+");
                String side = data[0];
                String username = data[1];

                users.putIfAbsent(side, new ArrayList<>());
                if (!users.get(side).contains(username)) {
                    users.get(side).add(username);
                }

            } else if (input.contains(" -> ")) {
                String[] data = input.split("\\s+->\\s+");
                String username = data[0];
                String side = data[1];

                users.forEach((k, v) -> v.remove(username));

                users.putIfAbsent(side, new ArrayList<>());
                users.get(side).add(username);
                System.out.printf("%s joins the %s side!\n", username , side);
            }
        }



        users.forEach((k ,v) -> {
            if (v.size() != 0) {
                System.out.printf("Side: %s, Members: %d\n", k, v.size());
                v.forEach(user -> System.out.println("! " + user));
            }
        });
    }
}
