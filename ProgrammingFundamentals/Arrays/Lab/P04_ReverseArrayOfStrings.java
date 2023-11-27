package ProgrammingFundamentals.Arrays.Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elementsArr = scanner.nextLine().split(" ");

        for (int i = 0; i < elementsArr.length / 2; i++) {
            String oldEl = elementsArr[i];
            elementsArr[i] = elementsArr[elementsArr.length - 1 - i];
            elementsArr[elementsArr.length - 1 - i] = oldEl;
        }

        System.out.println(String.join(" ", elementsArr));
    }
}
