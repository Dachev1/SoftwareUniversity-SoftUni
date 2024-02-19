package DefiningClasses.Lab.Bank;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        Map<Integer, BankAccount> bankAccountMap = new TreeMap<>();

        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created\n", bankAccount.getId());
                    break;

                case "Deposit":
                    int idForDeposit = Integer.parseInt(tokens[1]);
                    if (bankAccountMap.containsKey(idForDeposit)) {
                        double amount = Double.parseDouble(tokens[2]);
                        bankAccountMap.get(idForDeposit).deposit(amount);

                        System.out.printf("Deposited %.0f to ID%d\n", amount, idForDeposit);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;

                case "GetInterest":
                    int idForInterest = Integer.parseInt(tokens[1]);

                    if (bankAccountMap.containsKey(idForInterest)) {
                        int years = Integer.parseInt(tokens[2]);
                        System.out.printf("%.2f\n", bankAccountMap.get(idForInterest).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}
