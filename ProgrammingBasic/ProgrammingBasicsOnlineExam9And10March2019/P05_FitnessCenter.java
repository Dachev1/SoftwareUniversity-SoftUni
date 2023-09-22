package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P05_FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int membersCount = Integer.parseInt(scanner.nextLine());

        int backCount = 0;
        int chestCount = 0;
        int legsCount = 0;
        int absCount = 0;
        int proteinShakeCount = 0;
        int proteinBarCount = 0;

        for (int i = 1; i <= membersCount ; i++) {
            String command = scanner.nextLine();

            if (command.equals("Back")) {
                backCount++;
            } else if (command.equals("Chest")) {
                chestCount++;
            } else if (command.equals("Legs")) {
                legsCount++;
            } else if (command.equals("Abs")) {
                absCount++;
            } else if (command.equals("Protein shake")) {
                proteinShakeCount++;
            } else if (command.equals("Protein bar")) {
                proteinBarCount++;
            }
        }

        System.out.println(backCount + " - " + "back");
        System.out.println(chestCount + " - " + "chest");
        System.out.println(legsCount + " - " + "legs");
        System.out.println(absCount + " - " + "abs");
        System.out.println(proteinShakeCount + " - " + "protein shake");
        System.out.println(proteinBarCount + " - " + "protein bar");

        int trainingMembers = backCount + chestCount + legsCount + absCount;
        int buyStuffMembers = proteinShakeCount + proteinBarCount;
        System.out.printf("%.2f%% - work out%n", (trainingMembers * 1.0 / membersCount) * 100);
        System.out.printf("%.2f%% - protein%n", (buyStuffMembers * 1.0 / membersCount) * 100);
    }
}
