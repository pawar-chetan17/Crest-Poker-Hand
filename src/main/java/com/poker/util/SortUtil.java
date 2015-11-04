package com.poker.util;

import com.poker.model.PokerCard;
import com.poker.model.PokerCardSuit;
import com.poker.model.PokerCardValue;

import java.util.*;

public class SortUtil {

    public static Map<PokerCardSuit, Integer> sortHandBySuit(List<PokerCard> cards) {
        Map<PokerCardSuit, Integer> suitMap = new HashMap<>();
        for (PokerCard card : cards) {
            Integer suitCount = suitMap.get(card.getSuit());
            suitMap.put(card.getSuit(), (suitCount == null) ? 1 : suitCount + 1);
        }
        return suitMap;
    }

    public static Map<PokerCardValue, Integer> sortHandByValue(List<PokerCard> cards) {
        Map<PokerCardValue, Integer> valueMap = new HashMap<>();
        for(PokerCard card : cards) {
            Integer valueCount = valueMap.get(card.getValue());
            valueMap.put(card.getValue(), (valueCount == null) ? 1 : valueCount + 1);
        }
        return valueMap;
    }

    public static Map<String,Integer> sortRulePriorities(Map<String,Integer> priorities){
        ValueComparator vc =  new ValueComparator(priorities);
        Map<String, Integer> sortedMap = new TreeMap<>(vc);
        sortedMap.putAll(priorities);
        return sortedMap;
    }
}
