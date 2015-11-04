package com.poker.controller;

import com.poker.model.PokerCardSuit;
import com.poker.model.PokerCardValue;
import com.poker.rulehandler.FlushRuleHandler;
import com.poker.rulehandler.RoyalFlushRuleHandler;
import com.poker.rulehandler.StraightFlushRuleHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@SuppressWarnings("CallToPrintStackTrace")
public class RuleLoader {
    public static final String PACKAGE_NAME = "com.poker.rulehandler.";

    /**
     * Loading the rule at runtime using Reflection
     * @param ruleName
     * @param suitMap
     * @param valueMap
     * @return String : Specific rule which is satisfied
     */
    public static String loadPokerRule(String ruleName,Map<PokerCardSuit, Integer> suitMap,Map<PokerCardValue, Integer> valueMap){
        try {
            Class<?> cls = Class.forName(PACKAGE_NAME + ruleName);
            Object obj = cls.newInstance();

            if(RoyalFlushRuleHandler.class.isInstance(obj)
                    || FlushRuleHandler.class.isInstance(obj)
                    || StraightFlushRuleHandler.class.isInstance(obj)){
                Method method = cls.getDeclaredMethod("isRuleApplicable",Map.class,Map.class);
                return (String) method.invoke(obj,suitMap,valueMap);
            } else {
                Method method = cls.getDeclaredMethod("isRuleApplicable",Map.class);
                return (String) method.invoke(obj,valueMap);
            }
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
