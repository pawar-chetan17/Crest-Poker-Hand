package com.poker.inputanalyser;

import com.poker.exception.InvalidInputException;
import com.poker.model.PokerCard;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public final class FileReader {
    private static BufferedReader bufferedReader = null;
    private static final String SPLIT_PATTERN = ",";

    /**
     * FileReader : responsible for reading the input file
     * @return selectedCards Array
     * @throws IOException
     */
    public static List<List<PokerCard>> readInput() throws IOException {
        List<List<PokerCard>> selectedCards = new ArrayList<>();
        try {
            InputStream in = FileReader.class.getClassLoader().getResourceAsStream("InputFile.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(in));

            String cmmLine;
            while ((cmmLine = bufferedReader.readLine()) != null) {
                String[] slittedCards = cmmLine.split(SPLIT_PATTERN);
                if(slittedCards.length == 5){
                    List<String> selectedCards1 = new ArrayList<>();
                    Collections.addAll(selectedCards1, slittedCards);
                    selectedCards.add(PokerCardValidator.validateSelectedCards(selectedCards1));
                } else {
                    throw new InvalidInputException("5 cards are must in PokerHand");
                }
            }
        } catch (InvalidInputException e) {
            log.error("Invalid Input");
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return selectedCards;
        }
    }
}
