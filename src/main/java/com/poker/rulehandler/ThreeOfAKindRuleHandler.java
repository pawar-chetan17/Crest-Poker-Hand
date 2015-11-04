package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;

/**
 * ThreeOfAKindRuleHandler
 */
public class ThreeOfAKindRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public ThreeOfAKindRuleHandler() {
        super(RuleHandlerType.THREE_OF_A_KIND);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        PokerCardValue threeMatch = null;
        for (Map.Entry<PokerCardValue, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() == 3) {
                threeMatch = entry.getKey();
            }
        }
        if(threeMatch != null) {
            return "Three-Of-A-Kind";
        }
        return null;
    }
}
