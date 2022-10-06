package de.tei.codeexample.cleancode.model;

import java.util.Arrays;

public enum DayOfType {
    WEEK("WEEK"), MONTH("MONTH"), YEAR("YEAR");

    final String value;

    DayOfType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
