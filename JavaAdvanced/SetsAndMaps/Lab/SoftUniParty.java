import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        String line;
        while (!"PARTY".equals(line = scanner.nextLine())) {
            if (Character.isDigit(line.charAt(0))) {
                vipGuests.add(line);
            } else {
                regularGuests.add(line);
            }
        }

        while (!"END".equals(line = scanner.nextLine())) {
            regularGuests.remove(line);
            vipGuests.remove(line);
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
