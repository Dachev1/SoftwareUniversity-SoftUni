package ProgrammingFundamentals.Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];

            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(inputArgs[1]);
                    if (numbers.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

                    break;

                case "Print":
                    String evenOrOdd = inputArgs[1];

                    if (evenOrOdd.equals("even")) {
                        for (int num : numbers) {
                            if (num % 2 == 0) {
                                System.out.print(num + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        for (int num : numbers) {
                            if (num % 2 != 0) {
                                System.out.print(num + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case "Get":
                    int sum = 0;
                    for (int num : numbers) {
                        sum += num;
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    String condition = inputArgs[1];
                    int num = Integer.parseInt(inputArgs[2]);

                    switch (condition) {
                        case "<":
                            for (int currentNumber : numbers) {
                                if (currentNumber < num) {
                                    System.out.print(currentNumber + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case ">":
                            for (int currentNumber : numbers) {
                                if (currentNumber > num) {
                                    System.out.print(currentNumber + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case "<=":
                            for (int currentNumber : numbers) {
                                if (currentNumber <= num) {
                                    System.out.print(currentNumber + " ");
                                }
                            }
                            System.out.println();
                            break;

                        case ">=":
                            for (int currentNumber : numbers) {
                                if (currentNumber >= num) {
                                    System.out.print(currentNumber + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

