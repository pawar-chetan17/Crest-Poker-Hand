package com.poker.inputanalyser;

import com.poker.exception.InvalidInputException;
import com.poker.model.PokerCard;
import com.poker.util.CardDeckGenerator;

import java.util.ArrayList;
import java.util.List;

public class PokerCardValidator {

    /**
     * Method : Validate cards using the cards present in the Card deck
     * @param selectedCards
     * @return validated poker cards
     * @throws InvalidInputException
     */
    public static List<PokerCard> validateSelectedCards (List<String> selectedCards) throws InvalidInputException {
        List<PokerCard> pokerCards = new ArrayList<>();
        for(String selectedCard : selectedCards){
            if(CardDeckGenerator.cardDeckMap.containsKey(selectedCard)){
                pokerCards.add(CardDeckGenerator.cardDeckMap.get(selectedCard));
            } else {
                throw new InvalidInputException("Selected cards are invalid");
            }
        }
        return pokerCards;
    }
}
