package working_with_abstraction.exercise.CardsWithPower;

public class Card {
    private RankPower cardRank;
    private SuitPower cardSuit;

    public Card(RankPower cardRank, SuitPower cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getPower() {
        return cardRank.getPower() + cardSuit.getPower();
    }

    public void print() {
        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                this.cardRank.name(),
                this.cardSuit.name(),
                getPower()));
    }
}
