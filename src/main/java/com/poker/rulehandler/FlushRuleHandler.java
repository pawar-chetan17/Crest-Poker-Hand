package com.poker.rulehandler;

import com.poker.model.PokerCardSuit;
import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandler;

import com.poker.model.RuleHandlerType;

import java.util.Map;

/**
 * Flush Rule Handler
 */
public class FlushRuleHandler extends RuleHandler implements IFlushRuleHandler {

    public FlushRuleHandler() {
        super(RuleHandlerType.FlUSH);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardSuit, Integer> suitMap, Map<PokerCardValue, Integer> valueMap) {
        if(suitMap.keySet().size() == 1){
            return "Flush";
        }
        return null;
    }
}
