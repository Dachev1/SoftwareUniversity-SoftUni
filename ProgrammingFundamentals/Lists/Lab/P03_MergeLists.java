package ProgrammingFundamentals.Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MergeLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //3 5 2 43 12 3 54 10 23
        //76 5 34 2 4 12

        List<String> firstSeq = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        List<String> secondSeq = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        int shorterSeq = Math.min(firstSeq.size(), secondSeq.size());

        for (int i = 0; i < shorterSeq; i++) {
            result.add(firstSeq.get(i));
            result.add(secondSeq.get(i));
        }

        if (firstSeq.size() > shorterSeq) {
            for (int i = shorterSeq; i < firstSeq.size(); i++) {
                result.add(firstSeq.get(i));
            }
        } else {
            for (int i = shorterSeq; i < secondSeq.size(); i++) {
                result.add(secondSeq.get(i));
            }
        }

        for (String num : result) {
            System.out.print(num + " ");
        }
    }
}
