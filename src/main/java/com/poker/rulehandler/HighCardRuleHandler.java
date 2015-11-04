package com.poker.rulehandler;


import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;

/**
 * HighCardRuleHandler
 */
public class HighCardRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public HighCardRuleHandler() {
        super(RuleHandlerType.HIGH_CARD);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        return "High card";
    }
}
