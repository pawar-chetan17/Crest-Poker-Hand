package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;
import java.util.Map.Entry;

/**
 * OnePairRuleHandler
 */
public class OnePairRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {


    public OnePairRuleHandler() {
        super(RuleHandlerType.ONE_PAIR);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        PokerCardValue pair = null;
        for (Entry<PokerCardValue, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() == 2) {
                pair = entry.getKey();
            }
        }
        if(pair != null) {
            return "One-Pair";
        }
        return null;
    }
}
