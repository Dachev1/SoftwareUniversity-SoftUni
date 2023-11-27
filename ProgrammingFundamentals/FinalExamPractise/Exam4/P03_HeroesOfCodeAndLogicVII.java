package ProgrammingFundamentals.FinalExamPractise.Exam4;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> heroHealthPoints =new LinkedHashMap<>();
        LinkedHashMap<String, Integer> heroManaPoints =new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            String heroName = line[0];
            int healthPoints = Integer.parseInt(line[1]);
            int manaPoints = Integer.parseInt(line[2]);

            heroHealthPoints.put(heroName, healthPoints);
            heroManaPoints.put(heroName, manaPoints);
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            String[] data = line.split(" - ");
            String command = data[0];
            String hero = data[1];

            if (command.equals("CastSpell")) {
                int manaPointsNeeded = Integer.parseInt(data[2]);
                String spellName = data[3];

                if (heroManaPoints.get(hero) >= manaPointsNeeded) {
                    int afterSpellManaPoints = heroManaPoints.get(hero) - manaPointsNeeded;
                    heroManaPoints.put(hero, afterSpellManaPoints);
                    System.out.printf("%s has successfully cast %s and now has %d MP!\n", hero, spellName, afterSpellManaPoints);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!\n", hero, spellName);
                }
            } else if (command.equals("TakeDamage")) {
                int damage = Integer.parseInt(data[2]);
                String attacker = data[3];

                int healthPointsAfterAttack = heroHealthPoints.get(hero) - damage;

                if (healthPointsAfterAttack > 0) {
                    heroHealthPoints.put(hero, healthPointsAfterAttack);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", hero, damage, attacker, healthPointsAfterAttack);
                } else {
                    heroHealthPoints.remove(hero);
                    heroManaPoints.remove(hero);
                    System.out.printf("%s has been killed by %s!\n", hero, attacker);
                }
            } else if (command.equals("Recharge")) {
                int amount = Integer.parseInt(data[2]);

                int afterRecharge = Math.min(heroManaPoints.get(hero) + amount, 200);
                int amountRecovered = afterRecharge - heroManaPoints.get(hero);
                heroManaPoints.put(hero, afterRecharge);

                System.out.printf("%s recharged for %d MP!\n", hero, amountRecovered);
            } else if (command.equals("Heal")) {
                int amount = Integer.parseInt(data[2]);

                int afterHealed = Math.min(heroHealthPoints.get(hero) + amount, 100);
                int healedFor = afterHealed - heroHealthPoints.get(hero);
                heroHealthPoints.put(hero, afterHealed);

                System.out.printf("%s healed for %d HP!\n", hero, healedFor);
            }
        }

        for (String name : heroHealthPoints.keySet()) {
            System.out.println(name);
            System.out.printf("  HP: %d\n", heroHealthPoints.get(name));
            System.out.printf("  MP: %d\n", heroManaPoints.get(name));
        }
    }
}
