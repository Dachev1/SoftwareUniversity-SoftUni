package ExamPreparation.June_17_2023;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tools::offer);

        Deque<Integer> substances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(substances::push);

        List<Integer> challenges = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {
            int tool = tools.peek();
            int substance = substances.peek();

            int multiplied = tool * substance;
            boolean isNotMatch = true;

            for (Integer challenge : challenges) {
                isNotMatch = true;

                if (multiplied == challenge) {
                    tools.poll();
                    substances.pop();
                    challenges.remove(challenge);
                    isNotMatch = false;
                    break;
                }
            }

            if (isNotMatch) {
                int updateTool = tools.poll() + 1;
                tools.offer(updateTool);

                int updateSubstance = substances.pop() - 1;
                if (updateSubstance > 0) {
                    substances.push(updateSubstance);
                }
            }
        }

        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        printRemaingItems(tools, substances, challenges);
    }

    private static void printRemaingItems(Deque<Integer> tools, Deque<Integer> substances, List<Integer> challenges) {
        if (!tools.isEmpty()) {
            List<Integer> toolsList = new ArrayList<>(tools);
            System.out.println("Tools: " + String.join(",", toolsList.toString().replaceAll("[\\[\\]]", "")));
        }

        if (!substances.isEmpty()) {
            List<Integer> substancesList = new ArrayList<>(substances);
            System.out.println("Substances: " + String.join(",", substancesList.toString().replaceAll("[\\[\\]]", "")));
        }

        if (!challenges.isEmpty()) {
            List<Integer> challengesList = new ArrayList<>(challenges);
            System.out.println("Challenges: " + String.join(",", challengesList.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
