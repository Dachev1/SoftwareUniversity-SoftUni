package ExamPreparation.August_18_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class KAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> licensePlates = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(licensePlates::offer);

        Deque<Integer> cars = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(cars::push);

        int days = 0;
        int registeredCars = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            days++;

            int carForRegistrations = cars.pop();
            int plates = licensePlates.poll() / 2;

            if (carForRegistrations == plates) {
                registeredCars += carForRegistrations;
                continue;
            } else if (carForRegistrations > plates) {
                carForRegistrations -= plates;
                registeredCars += plates;
                cars.addLast(carForRegistrations);
            } else {
                plates -= carForRegistrations;
                registeredCars += carForRegistrations;
                licensePlates.offer(plates * 2);
            }
        }

        System.out.printf("%d cars were registered for %d days!\n", registeredCars, days);

        if (licensePlates.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!licensePlates.isEmpty()) {
            int total = 0;
            while (!licensePlates.isEmpty()) {
                total += licensePlates.poll();
            }
            System.out.printf("%d license plates remain!\n", total);
        } else {
            int total = 0;
            while (!cars.isEmpty()) {
                total += cars.pop();
            }
            System.out.printf("%d cars remain without license plates!\n", total);
        }
    }
}
