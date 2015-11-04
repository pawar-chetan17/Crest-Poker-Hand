package com.poker.model;

public class PokerCard {
    private PokerCardSuit suit;
    private PokerCardValue value;

    public PokerCard(PokerCardSuit suit, PokerCardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public PokerCardSuit getSuit() {
        return suit;
    }

    public PokerCardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PokerCard{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
