package com.poker.controller;

import com.poker.exception.PokerRulePrioritiesNotFoundException;
import com.poker.inputanalyser.FileReader;
import com.poker.inputanalyser.PropertyFileReader;
import com.poker.model.*;
import com.poker.util.SortUtil;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Entry point of the application
 */
@Log4j2
public class PokerCardController {
    public static void main(String... args) throws IOException, PokerRulePrioritiesNotFoundException {
        List<List<PokerCard>> selectedPokerCards =  FileReader.readInput();
        Map<String,Integer> rulePriorityMap = PropertyFileReader.getProperties();
        if (selectedPokerCards != null) {
            for(List<PokerCard> selectedCards : selectedPokerCards) {
                String ruleName = null;
                Map<PokerCardSuit, Integer> suitMap = SortUtil.sortHandBySuit(selectedCards);
                Map<PokerCardValue, Integer> valueMap = SortUtil.sortHandByValue(selectedCards);
                Iterator<Entry<String,Integer>> iterator = rulePriorityMap != null ? rulePriorityMap.entrySet().iterator() : null;
                while ((iterator != null && iterator.hasNext()) && ruleName == null) {
                    Entry<String,Integer> entry = iterator.next();
                    ruleName = RuleLoader.loadPokerRule(entry.getKey(),suitMap,valueMap);
                }
                log.info(ruleName);
            }
        }
    }
}
