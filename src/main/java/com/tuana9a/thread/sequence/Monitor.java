package com.tuana9a.thread.sequence;

public class Monitor {
    public int turn;
    private int maxTurn;

    public Monitor(int maxTurn) {
        turn = 0;
        this.maxTurn = maxTurn;
    }

    public void switchTurn() {
        turn++;
        if (turn > maxTurn) {
            turn = 0;
        }
    }
}
