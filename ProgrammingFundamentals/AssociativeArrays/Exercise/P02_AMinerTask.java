package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        for (;;) {
            String type = scanner.nextLine();

            if (type.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(type, 0);
            resources.put(type, resources.get(type) + quantity);
        }

        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
