package com.poker.rulehandler;

import com.poker.model.*;
import com.poker.util.RuleFactory;

import java.util.Map;

/**
 * RoyalFlushRuleHandler
 */
public class RoyalFlushRuleHandler extends com.poker.model.RuleHandler implements IFlushRuleHandler {


    public RoyalFlushRuleHandler() {
        super(RuleHandlerType.ROYAL_FLUSH);
    }

    private boolean isAceThroughTen(Map<PokerCardValue, Integer> valueMap) {
        if (valueMap.get(PokerCardValue.ACE) != null) {
            if (valueMap.get(PokerCardValue.KING) != null) {
                if (valueMap.get(PokerCardValue.QUEEN) != null) {
                    if (valueMap.get(PokerCardValue.JACK) != null) {
                        if (valueMap.get(PokerCardValue.TEN) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String isRuleApplicable(Map<PokerCardSuit, Integer> suitMap, Map<PokerCardValue, Integer> valueMap) {
        StraightFlushRuleHandler straightFlushRuleHandler = (StraightFlushRuleHandler) RuleFactory.buildRule(RuleHandlerType.STRAIGHT_FLUSH);
        if(straightFlushRuleHandler.isRuleApplicable(suitMap, valueMap) != null && isAceThroughTen(valueMap)) {
            return "Royal-Flush";
        }
        return null;
    }
}
