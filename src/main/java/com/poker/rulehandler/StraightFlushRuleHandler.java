package com.poker.rulehandler;

import com.poker.model.*;
import com.poker.util.RuleFactory;

import java.util.Map;

/**
 * StraightFlushRuleHandler
 */
public class StraightFlushRuleHandler extends com.poker.model.RuleHandler implements IFlushRuleHandler {

    public StraightFlushRuleHandler() {
        super(RuleHandlerType.STRAIGHT_FLUSH);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardSuit, Integer> suitMap, Map<PokerCardValue, Integer> valueMap) {
        StraightRuleHandler straightRuleHandler = (StraightRuleHandler) RuleFactory.buildRule(RuleHandlerType.STRAIGHT);
        FlushRuleHandler flushRuleHandler = (FlushRuleHandler) RuleFactory.buildRule(RuleHandlerType.FlUSH);
        if(straightRuleHandler.isRuleApplicable(valueMap) != null && flushRuleHandler.isRuleApplicable(suitMap,valueMap) != null) {
            return "Straight-Flush";
        }
        return null;
    }
}
