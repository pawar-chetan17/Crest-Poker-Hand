package com.poker.rulehandler;

import com.poker.model.PokerCardValue;
import com.poker.model.RuleHandlerType;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Log4j2
public class StraightRuleHandler extends com.poker.model.RuleHandler implements RuleHandler {

    public StraightRuleHandler() {
        super(RuleHandlerType.STRAIGHT);
    }

    @Override
    public String isRuleApplicable(Map<PokerCardValue, Integer> valueMap) {
        if (valueMap.size() != 5) {
            return null;
        }
        List<Integer> cardValues = new ArrayList<>();
        for (PokerCardValue value : valueMap.keySet()) {
            cardValues.add(value.getOrder());
        }
        Collections.sort(cardValues);
        Integer checkVal = null;
        Integer count = 0;
        for(Integer val : cardValues) {
            if ((checkVal != null) && (checkVal != val - 1) && count < 3) {
                return null;
            }
            count++;
            checkVal = val;
        }
        return "Straight";
    }
}
