package com.solvd.bank.Classes;

import java.util.HashMap;

public class Currency {
    private String name;
    private String shortName;
    private HashMap<String, Float> exchangeValues;

    public Currency() {}

    public Currency(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Currency(String name, String shortName, HashMap<String, Float> exchangeValues) {
        this.name = name;
        this.shortName = shortName;
        this.exchangeValues = exchangeValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public HashMap<String, Float> getExchangeValues() {
        return exchangeValues;
    }

    public void setExchangeValues(HashMap<String, Float> exchangeValues) {
        this.exchangeValues = exchangeValues;
    }

    public boolean putExchangeValue(String key, float value) {
        if(exchangeValues != null)
        {
            exchangeValues.put(key, value);
            return true;
        }else
            return false;
    }
}
