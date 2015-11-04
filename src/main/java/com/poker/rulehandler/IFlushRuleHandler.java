package com.poker.rulehandler;

import com.poker.model.PokerCardSuit;
import com.poker.model.PokerCardValue;

import java.util.Map;

public interface IFlushRuleHandler {
    String isRuleApplicable(Map<PokerCardSuit, Integer> suitMap, Map<PokerCardValue, Integer> valueMap);
}
