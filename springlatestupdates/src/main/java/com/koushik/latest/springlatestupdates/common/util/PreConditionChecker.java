package com.koushik.latest.springlatestupdates.common.util;

public class PreConditionChecker {

    public static void checkArgument(boolean state) {
        if(!state) {
            throw new IllegalArgumentException();
        }
    }
}
