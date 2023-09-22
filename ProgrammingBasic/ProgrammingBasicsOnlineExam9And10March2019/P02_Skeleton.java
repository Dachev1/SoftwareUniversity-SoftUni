package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P02_Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesControl = Integer.parseInt(scanner.nextLine());
        int secondsControl = Integer.parseInt(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        int secondsFor100Meters = Integer.parseInt(scanner.nextLine());

        int controlSeconds = (minutesControl * 60) + secondsControl;
        double slow = (meters / 120) * 2.5;

        double totalTime = (meters / 100) * secondsFor100Meters - slow;

        if (totalTime <= controlSeconds) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", totalTime);
        } else {
            double diff = Math.abs(totalTime - controlSeconds);
            System.out.printf("No, Marin failed! He was %.3f second slower.", diff);
        }
    }
}
