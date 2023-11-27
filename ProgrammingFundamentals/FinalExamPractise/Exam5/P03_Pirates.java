package ProgrammingFundamentals.FinalExamPractise.Exam5;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> cityPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> cityGold= new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Sail")) {
                break;
            }

            String[] data = line.split("\\|\\|");
            String city = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);

            if (cityPopulation.containsKey(city)) {
                cityPopulation.put(city, cityPopulation.get(city) + population);
                cityGold.put(city, cityGold.get(city) + gold);
            } else {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
            }
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            String[] data = line.split("=>");
            String command = data[0];
            String city = data[1];

            if (command.equals("Plunder")) {
                int people = Integer.parseInt(data[2]);
                int gold = Integer.parseInt(data[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", city, gold, people);
                int peopleAfterRaid = cityPopulation.get(city) - people;
                int goldAfterRaid = cityGold.get(city) - gold;

                if (peopleAfterRaid <= 0 || goldAfterRaid <= 0) {
                    cityPopulation.remove(city);
                    cityGold.remove(city);
                    System.out.printf("%s has been wiped off the map!\n", city);
                } else {
                    cityPopulation.put(city, peopleAfterRaid);
                    cityGold.put(city, goldAfterRaid);
                }
            } else if (command.equals("Prosper")) {
                int gold = Integer.parseInt(data[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!" );
                    continue;
                }

                int afterAddedGold = cityGold.get(city) + gold;
                cityGold.put(city, afterAddedGold);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, city, afterAddedGold);
            }
        }

        if (cityPopulation.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cityPopulation.size());
            for (String city : cityPopulation.keySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", city, cityPopulation.get(city), cityGold.get(city));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
