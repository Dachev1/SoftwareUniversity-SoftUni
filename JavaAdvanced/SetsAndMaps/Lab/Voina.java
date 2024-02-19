import java.util.*;
import java.util.stream.Collectors;

public class Voina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> player1Cards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> player2Cards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<Integer> player1 = new LinkedHashSet<>(player1Cards);
        Set<Integer> player2 = new LinkedHashSet<>(player2Cards);

        for (int i = 0; i < 50; i++) {
            int player1Card = player1.iterator().next();
            player1.remove(player1Card);

            int player2Card = player2.iterator().next();
            player2.remove(player2Card);

            if (player1Card > player2Card) {
                player1.add(player1Card);
                player1.add(player2Card);
            } else if (player2Card > player1Card) {
                player2.add(player1Card);
                player2.add(player2Card);
            }

            if (player1.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (player2.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
        }

        if (player1.size() > player2.size()) {
            System.out.println("First player win!");
        } else if (player2.size() > player1.size()) {
            System.out.println("Second player win!");
        }
    }
}
