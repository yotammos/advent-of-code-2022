package com.mosscorp.advent.day2;

public enum OpponentMove {
    Rock('A'),
    Paper('B'),
    Scissors('C');

    private final char charValue;

    OpponentMove(final char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }
}
