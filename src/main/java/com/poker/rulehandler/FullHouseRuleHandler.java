package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;

import java.util.Map;
import java.util.Map.Entry;

public class FullHouseRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public FullHouseRuleHandler() {
        super(RuleHandlerType.FULL_HOUSE);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        PokerCardValue threeMatch = null;
        PokerCardValue twoMatch = null;
        for (Entry<PokerCardValue, Integer> entry : valueMap.entrySet()) {
            if (entry.getValue() == 3) {
                threeMatch = entry.getKey();
            } else if (entry.getValue() == 2) {
                twoMatch = entry.getKey();
            }
        }
        if((threeMatch != null) && (twoMatch != null)){
            return "Full-House";
        }
        return null;
    }
}
