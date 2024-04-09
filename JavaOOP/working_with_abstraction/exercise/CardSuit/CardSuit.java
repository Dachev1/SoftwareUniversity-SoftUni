package working_with_abstraction.exercise.CardSuit;

import java.util.Arrays;

public enum CardSuit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public static void print() {
        System.out.println("Card Suits:");
        Arrays.stream(CardSuit.values())
                .forEach(card -> System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name()));
    }
}
