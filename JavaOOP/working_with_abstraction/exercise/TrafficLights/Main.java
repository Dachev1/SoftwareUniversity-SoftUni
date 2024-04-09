package working_with_abstraction.exercise.TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

import static working_with_abstraction.exercise.TrafficLights.Signal.printSignals;
import static working_with_abstraction.exercise.TrafficLights.Signal.updateSignals;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Signal[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Signal::valueOf)
                .toArray(Signal[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateSignals(signals);
            printSignals(signals);
        }
    }
}
