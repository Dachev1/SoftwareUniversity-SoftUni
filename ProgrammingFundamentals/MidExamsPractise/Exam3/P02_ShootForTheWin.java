package ProgrammingFundamentals.MidExamsPractise.Exam3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int hitTargets = 0;
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            int idx = Integer.parseInt(line);

            if (idx >= 0 && idx <= targets.size() - 1) {
                int removedTargetValue = targets.get(idx);

                if (removedTargetValue != -1) {
                    hitTargets++;
                    targets.set(idx, -1);

                    modifiedTarget(targets, idx, removedTargetValue);
                }
            }
        }

        //"Shot targets: {count} -> {target1} {target2}… {targetn}"
        System.out.printf("Shot targets: %d -> ", hitTargets);
        System.out.print(String.format(String.valueOf(targets))
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }

    public static void modifiedTarget(List<Integer> targets, int idx, int removedTargetValue) {
        for (int i = 0; i < targets.size(); i++) {
            int currentTarget = targets.get(i);

            if (currentTarget != -1) {

                if (removedTargetValue < currentTarget) {
                    targets.set(i, currentTarget - removedTargetValue);
                } else {
                    targets.set(i, currentTarget + removedTargetValue);
                }
            }
        }
    }
}
