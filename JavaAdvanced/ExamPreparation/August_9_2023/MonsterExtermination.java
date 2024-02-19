package ExamPreparation.August_9_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monsters = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(monsters::offer);

        Deque<Integer> solders = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(solders::push);

        int killedMonsters = 0;
        while (!monsters.isEmpty() && !solders.isEmpty()) {
            int monster = monsters.peek();
            int solder = solders.peek();

            if (solder >= monster) {
                int addToTheNextSolder = solders.pop() - monsters.poll();
                if (addToTheNextSolder > 0 && !solders.isEmpty()) {
                    solders.push(solders.pop() + addToTheNextSolder);
                } else if (addToTheNextSolder > 0) {
                    solders.push(addToTheNextSolder);
                }

                killedMonsters++;
            } else {
                int monstersHealthAfterAttack = monsters.poll() - solders.pop();
                monsters.offer(monstersHealthAfterAttack);
            }
        }

        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (solders.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
