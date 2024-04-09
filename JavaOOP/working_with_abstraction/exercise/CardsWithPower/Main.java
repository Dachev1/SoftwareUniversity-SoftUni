package working_with_abstraction.exercise.CardsWithPower;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       RankPower rank = RankPower.valueOf(scanner.nextLine());
       SuitPower suit = SuitPower.valueOf(scanner.nextLine());

       Card card = new Card(rank, suit);

       card.print();
    }
}
