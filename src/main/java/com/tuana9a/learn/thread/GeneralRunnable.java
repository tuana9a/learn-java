package com.tuana9a.learn.thread;

public abstract class GeneralRunnable implements Runnable {
    String name;
    public GeneralRunnable(String name) {
        this.name = name;
    }
}
