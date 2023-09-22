package Labs.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int totalTimeInMinutesPlus30Minutes = (hour * 60) + min + 30;

        hour = totalTimeInMinutesPlus30Minutes / 60;
        min = totalTimeInMinutesPlus30Minutes % 60;

        if (hour == 24) {
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, min);
    }
}
