package com.poker.util;

import com.poker.model.RuleHandler;
import com.poker.model.RuleHandlerType;
import com.poker.rulehandler.*;

/**
 * RuleFactory - consist of all rules , used Factory design pattern
 */
public final class RuleFactory {
    public static RuleHandler buildRule(RuleHandlerType ruleHandlerType) {
        RuleHandler ruleHandler = null;
        switch (ruleHandlerType) {
            case FlUSH:
                ruleHandler = new FlushRuleHandler();
                break;
            case FOUR_OF_A_KIND:
                ruleHandler = new FourOfAKindRuleHandler();
                break;
            case FULL_HOUSE:
                ruleHandler = new FullHouseRuleHandler();
                break;
            case HIGH_CARD:
                ruleHandler = new HighCardRuleHandler();
                break;
            case ONE_PAIR:
                ruleHandler = new OnePairRuleHandler();
                break;
            case ROYAL_FLUSH:
                ruleHandler = new RoyalFlushRuleHandler();
                break;
            case TWO_PAIR:
                ruleHandler = new TwoPairRuleHandler();
                break;
            case STRAIGHT:
                ruleHandler = new StraightRuleHandler();
                break;
            case STRAIGHT_FLUSH:
                ruleHandler = new StraightFlushRuleHandler();
                break;

            case THREE_OF_A_KIND:
                ruleHandler = new ThreeOfAKindRuleHandler();
                break;
        }
        return ruleHandler;
    }
}
