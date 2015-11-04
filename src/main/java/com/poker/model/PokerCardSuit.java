package com.poker.model;

public enum PokerCardSuit {
    HEART("H"),
    DIAMOND("D"),
    CLUB("C"),
    SPADE("S");

    private String shortName;

    PokerCardSuit(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName){
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "PokerCardSuite{" +
                "shortName='" + shortName + '\'' +
                '}';
    }
}
