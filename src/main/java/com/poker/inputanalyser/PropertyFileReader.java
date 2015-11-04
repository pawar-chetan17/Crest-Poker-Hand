package com.poker.inputanalyser;

import com.poker.exception.PokerRulePrioritiesNotFoundException;
import com.poker.util.SortUtil;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Log4j2
public class PropertyFileReader {
    /**
     * Method responsible for reading the properties from properties file and return the sorted properties
     * @return the properties
     * @throws PokerRulePrioritiesNotFoundException
     */
    public static Map<String,Integer> getProperties() throws PokerRulePrioritiesNotFoundException {
        Properties properties = new Properties();
        InputStream input = PropertyFileReader.class.getClassLoader().getResourceAsStream("poker.properties");
        if (input == null) {
            throw new PokerRulePrioritiesNotFoundException("Error reading Poker Rule Priority file");
        }
        try {
            properties.load(input);
            Enumeration<?> e = properties.propertyNames();
            Map<String,Integer> priorityMap = new HashMap<>();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                priorityMap.put(key, Integer.valueOf(value));
            }
            return SortUtil.sortRulePriorities(priorityMap);

        } catch (IOException e) {
            log.error("IOException while Checking the rules");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                log.error("IOException while releasing the resource");
                e.printStackTrace();
            }
        }
        return null;
    }
}
