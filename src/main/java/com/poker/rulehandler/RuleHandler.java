package com.poker.rulehandler;

import com.poker.model.PokerCardValue;

import java.util.Map;

public interface RuleHandler {
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap);
}
