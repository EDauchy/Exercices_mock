package org.example;

import jdk.jshell.spi.ExecutionControl;

public class DiceScore {

    private InterfaceDiceMock de;

    public int getScore() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Pas encore implémenté, le TDD oblige");
    }
}
