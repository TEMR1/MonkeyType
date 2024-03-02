package com.temr1.lesson2_3_maven.monkeytype.Models;

public class MistakesParameters {
    private final int counterOfMistakes;
    private final int numberOfSecond;

    public MistakesParameters(int counterOfMistakes, int numberOfSecond) {
        this.counterOfMistakes = counterOfMistakes;
        this.numberOfSecond = numberOfSecond;
    }

    public int getCounterOfMistakes() {
        return counterOfMistakes;
    }

    public int getNumberOfSecond() {
        return numberOfSecond;
    }
}
