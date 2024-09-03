package com.github.Rah.jrl.flappybird.utils;

public class Cycle {
    private final int[] pattern;
    private int index = 0;
    public Cycle(int[] pattern) {
        this.pattern = pattern;
    }

    public int next() {
        int value = pattern[index++];
        if(index >= pattern.length) {
            index = 0;
        }
        return value;
    }
}
