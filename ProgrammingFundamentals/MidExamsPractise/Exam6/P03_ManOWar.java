package ProgrammingFundamentals.MidExamsPractise.Exam6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Retire")) {
                break;
            }

            String command = input.split(" ")[0];

            if (command.equals("Fire")) {
                // pirateShip attack warShip
                int idx = Integer.parseInt(input.split(" ")[1]);
                int dmg = Integer.parseInt(input.split(" ")[2]);

                if (isValidIdx(warShip, idx)) {
                    int currentSectionHealth = warShip.get(idx);
                    int sectionAfterAttack = currentSectionHealth - dmg;

                    if (sectionAfterAttack <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    } else {
                        warShip.set(idx, sectionAfterAttack);
                    }
                }
            } else if (command.equals("Defend")) {
                // warShip attack pirateShip
                int startIdx = Integer.parseInt(input.split(" ")[1]);
                int endIdx = Integer.parseInt(input.split(" ")[2]);
                int dmg = Integer.parseInt(input.split(" ")[3]);

                if (isValidIdx(pirateShip, startIdx) && isValidIdx(pirateShip, endIdx)) {
                    for (int i = startIdx; i <= endIdx; i++) {
                        int currentSection = pirateShip.get(i);
                        int sectionAfterAttack = currentSection - dmg;

                        if (sectionAfterAttack <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        } else {
                            pirateShip.set(i, sectionAfterAttack);
                        }
                    }
                }
            } else if (command.equals("Repair")) {
                int idxToHeal = Integer.parseInt(input.split(" ")[1]);
                int health = Integer.parseInt(input.split(" ")[2]);

                if (isValidIdx(pirateShip, idxToHeal)) {
                    int currentHealth = pirateShip.get(idxToHeal);

                    pirateShip.set(idxToHeal, Math.min(currentHealth + health, maxHealthCapacity));
                }
            } else if (command.equals("Status")) {
                int sectionNeededRepairCount = 0;
                for (int section : pirateShip) {
                    if (section < maxHealthCapacity * 0.2) {
                        sectionNeededRepairCount++;
                    }
                }

                System.out.printf("%d sections need repair.\n", sectionNeededRepairCount);
            }
        }



        int pirateShipSum = 0;
        for (int currentSection : pirateShip) {
            pirateShipSum += currentSection;
        }

        int warshipSum = 0;
        for (int currentSection : warShip) {
            warshipSum += currentSection;
        }

        System.out.printf("Pirate ship status: %d\nWarship status: %d\n", pirateShipSum, warshipSum);
    }

    private static boolean isValidIdx(List<Integer> list, int idx) {
        return idx >= 0 && idx <= list.size() - 1;
    }
}
