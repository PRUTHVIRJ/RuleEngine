package com.rulemachine.model;

import java.util.HashMap;
import java.util.Map;


public class Context {
    private Map<String, String> fieldValues = new HashMap<>();

    public void setValue(String field, String value) {
        fieldValues.put(field, value);
    }

    public String getValue(String field) {
        return fieldValues.get(field);
    }
}
