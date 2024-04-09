package interfaces_and_abstraction.exercise.birthday_celebrations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Birthable> birthableMap = new HashMap<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] lineArgs = line.split("\\s+");

            switch (lineArgs[0]) {
                case "Citizen":
                    Birthable citizen = new Citizen(lineArgs[1], Integer.parseInt(lineArgs[2]), lineArgs[3], lineArgs[4]);
                    birthableMap.put(citizen.getBirthDate(), citizen);
                    break;
                case "Pet":
                    Birthable pet = new Pet(lineArgs[1], lineArgs[2]);
                    birthableMap.put(pet.getBirthDate(), pet);
                    break;
            }
        }

        String specificYear = scanner.nextLine();

        for (String birthdate : birthableMap.keySet()) {
            if (birthdate.endsWith(specificYear)) {
                System.out.println(birthdate);
            }
        }
    }
}