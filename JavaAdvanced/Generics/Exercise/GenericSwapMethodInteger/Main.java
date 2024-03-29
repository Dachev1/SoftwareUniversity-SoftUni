package Generics.Exercise.GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            boxes.add(box);
        }
        int[] swapElements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        swap(boxes, swapElements[0], swapElements[1]);
        for (int i = 0; i < boxes.size(); i++) {
            System.out.printf("%s%n", boxes.get(i));
        }
    }
    private static <T> void swap(List<T> data, int first, int second) {
        T firstElement = data.get(first);
        T secondElement = data.get(second);
        data.set(first, secondElement);
        data.set(second, firstElement);
    }
}