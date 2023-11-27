package ProgrammingFundamentals.FinalExamPractise.Exam2;

import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Travel")) {
                break;
            }

            String[] data = input.split(":");
            String command = data[0];

            switch (command) {
                case "Add Stop" -> {
                    int idx = Integer.parseInt(data[1]);
                    String stop = data[2];
                    if (isValidIdx(stops, idx)) {
                        stops.insert(idx, stop);
                    }
                }
                case "Remove Stop" -> {
                    int startIdx = Integer.parseInt(data[1]);
                    int endIdx = Integer.parseInt(data[2]);
                    if (isValidIdx(stops, startIdx) && isValidIdx(stops, endIdx)) {
                        stops.delete(startIdx, endIdx + 1);
                    }
                }
                case "Switch" -> {
                    String oldStr = data[1];
                    String newStr = data[2];
                    String replacedText = stops.toString().replace(oldStr, newStr);
                    stops = new StringBuilder(replacedText);
                }
            }

            System.out.println(stops);
        }

        System.out.printf("Ready for world tour! Planned stops: %s\n", stops);
    }

    private static boolean isValidIdx(StringBuilder stops, int idx) {
        return idx >= 0 && idx <= stops.length() - 1;
    }
}
