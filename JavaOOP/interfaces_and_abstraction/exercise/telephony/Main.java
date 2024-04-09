package interfaces_and_abstraction.exercise.telephony;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = List.of(scanner.nextLine().split("\\s+"));
        List<String> sites = List.of(scanner.nextLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(phoneNumbers, sites);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
