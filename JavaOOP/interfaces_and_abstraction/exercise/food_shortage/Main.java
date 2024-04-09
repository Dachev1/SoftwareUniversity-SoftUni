package interfaces_and_abstraction.exercise.food_shortage;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        Map<String ,Buyer> citizens = new HashMap<>();
        Map<String ,Buyer> rebels = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {
                Buyer citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                citizens.put(tokens[0] ,citizen);

            } else if (tokens.length == 3) {
                Buyer rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                rebels.put(tokens[0], rebel);
            }
        }

        String name;
        while (!"End".equals(name = scanner.nextLine())) {
            if (rebels.containsKey(name)) {
                rebels.get(name).buyFood();
            } else if (citizens.containsKey(name)) {
                citizens.get(name).buyFood();
            }
        }

        int totalFoodPurchased= 0;
        for (Map.Entry<String, Buyer> citizen : citizens.entrySet()) {
            totalFoodPurchased += citizen.getValue().getFood();

        }
        for (Map.Entry<String, Buyer> rebel : rebels.entrySet()) {
            totalFoodPurchased += rebel.getValue().getFood();
        }

        System.out.println(totalFoodPurchased);
    }
}
