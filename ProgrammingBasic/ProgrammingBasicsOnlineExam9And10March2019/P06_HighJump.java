package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P06_HighJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int desiredHeight = Integer.parseInt(scanner.nextLine());
        int barHeight = desiredHeight - 30;
        int failsAttempts = 0;

        for (int i = 1; ; i++) {
            int jumpHeight = Integer.parseInt(scanner.nextLine());

            if (jumpHeight > desiredHeight && barHeight >= desiredHeight) {
                System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", desiredHeight, i);
                break;
            } else if (jumpHeight > barHeight) {
                barHeight += 5;
                failsAttempts = 0;
            } else {
                failsAttempts++;
                if (failsAttempts == 3) {
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", barHeight, i);
                    break;
                }
            }
        }
    }
}