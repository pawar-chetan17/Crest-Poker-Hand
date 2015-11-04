package com.poker.util;

import com.poker.model.PokerCard;
import com.poker.model.PokerCardSuit;
import com.poker.model.PokerCardValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Returns the card decks
 */
public class CardDeckGenerator {
    public static final Map<String,PokerCard> cardDeckMap = new HashMap<>();

    static {
        for (PokerCardSuit suit : PokerCardSuit.values()) {
            for (PokerCardValue value : PokerCardValue.values()) {
                cardDeckMap.put(suit.getShortName()+value.getShortValue(),new PokerCard(suit, value));
            }
        }
    }
}
