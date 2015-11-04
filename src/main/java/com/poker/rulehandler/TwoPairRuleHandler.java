package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;
import java.util.Map.Entry;

/**
 * TwoPairRuleHandler
 */
public class TwoPairRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public TwoPairRuleHandler() {
        super(RuleHandlerType.TWO_PAIR);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        PokerCardValue firstPair = null;
        PokerCardValue secondPair = null;
        for (Entry<PokerCardValue, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() == 2) {
                if (firstPair == null) {
                    firstPair = entry.getKey();
                } else {
                    secondPair = entry.getKey();
                }
            }
        }
        if((firstPair != null) && (secondPair != null)){
            return "Two-Pair";
        }
        return null;
    }
}
