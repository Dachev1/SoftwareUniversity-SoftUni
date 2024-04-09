package working_with_abstraction.exercise.CardRank;

import java.util.Arrays;

public enum CardRank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static void print() {
        System.out.println("Card Ranks:");
        Arrays.stream(CardRank.values())
                .forEach(card -> System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name()));
    }
}
