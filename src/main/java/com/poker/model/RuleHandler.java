package com.poker.model;

public abstract class RuleHandler {
    private final RuleHandlerType ruleHandlerType;
    public RuleHandler(RuleHandlerType ruleHandlerType) {
        this.ruleHandlerType = ruleHandlerType;
    }
}
