package ExamPreparation.April_12_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RubberDuckDebuggers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> times = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(times::offer);

        Deque<Integer> tasks = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        int darthVaderDucky = 0; //0 - 60
        int thorDucky = 0; // 61 – 120
        int bigBlueRubberDucky = 0; // 121 - 180
        int smallYellowRubberDucky = 0; // 181 - 240
        while (!times.isEmpty() && !tasks.isEmpty()) {
            int time = times.poll();
            int task = tasks.pop();

            int multiply = time * task;

            if (multiply >= 0 && multiply <= 60) {
                darthVaderDucky++;
            } else if (multiply >= 61 && multiply <= 120) {
                thorDucky++;
            } else if (multiply >= 121 && multiply <= 180) {
                bigBlueRubberDucky++;
            } else if (multiply >= 181 && multiply <= 240) {
                smallYellowRubberDucky++;
            } else {
                tasks.push(task - 2);
                times.offer(time);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + darthVaderDucky);
        System.out.println("Thor Ducky: " + thorDucky);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucky);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucky);
    }
}
