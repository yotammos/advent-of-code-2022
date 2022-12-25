package com.mosscorp.advent.day2;

public enum Move {
    Rock('X'),
    Paper('Y'),
    Scissors('Z');

    private final char charValue;

    Move(final char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }
}
