package com.mosscorp.advent.day2;

public enum WantedResult {
    Lose('X'),
    Draw('Y'),
    Win('Z');

    private final char charValue;

    WantedResult(final char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }
}
