package com.poker.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public enum PokerCardValue {
    ACE("A",12),
    KING("K",11),
    QUEEN("Q",10),
    JACK("J",9),
    TEN("T",8),
    NINE("9",7),
    EIGHT("8",6),
    SEVEN("7",5),
    SIX("6",4),
    FIVE("5",3),
    FOUR("4",2),
    THREE("3",1),
    TWO("2",0);

    @Getter
    @Setter
    private String shortValue;

    @Getter
    private int order;

    PokerCardValue(String shortValue, int order) {
        this.shortValue = shortValue;
        this.order = order;
    }

    public String getShortValue() {
        return shortValue;
    }

    public void setShortValue(String shortValue){
        this.shortValue = shortValue;
    }

    @Override
    public String toString() {
        return "PokerCardValue{" +
                "shortValue='" + shortValue + '\'' +
                '}';
    }
}
