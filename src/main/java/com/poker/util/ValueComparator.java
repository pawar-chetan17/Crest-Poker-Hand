package com.poker.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/**
 * ValueComparator for comparing and sorting the properties
 */
public class ValueComparator implements Comparator<String>, Serializable {

    private Map<String, Integer> map;

    ValueComparator(Map<String, Integer> base) {
        this.map = base;
    }

    @Override
    public int compare(String o1, String o2) {
        return getMap().get(o1) <= getMap().get(o2) ? -1 : 1;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
