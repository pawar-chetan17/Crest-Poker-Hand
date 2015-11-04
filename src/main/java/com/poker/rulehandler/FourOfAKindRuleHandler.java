package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;
import java.util.Map.Entry;

/**
 * FourOfAKindRuleHandler
 */
public class FourOfAKindRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public FourOfAKindRuleHandler() {
        super(RuleHandlerType.FOUR_OF_A_KIND);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        PokerCardValue fourMatch = null;
        for (Entry<PokerCardValue, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() == 4) {
                fourMatch = entry.getKey();
            }
        }
        if(fourMatch != null) {
            return "Four-Of-A-Kind";
        }
        return null;
    }
}
