package ExamPreparation.June_26_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OSPlaning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        Deque<Integer> threads = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.pop();
            if (currentTask == taskToKill) {
                break;
            }

            int currentThread = threads.poll();
            if (currentThread < currentTask) {
                tasks.push(currentTask);
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), taskToKill);
        while (!threads.isEmpty()) {
            System.out.printf("%d ", threads.poll());
        }
    }
}