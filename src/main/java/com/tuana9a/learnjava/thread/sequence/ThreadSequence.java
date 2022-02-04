package com.tuana9a.learnjava.thread.sequence;

public class ThreadSequence extends Thread {
    String name;
    Monitor monitor;
    int turn;

    public ThreadSequence(String name, Monitor monitor, int turn) {
        this.name = name;
        this.monitor = monitor;
        this.turn = turn;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; ++i) {
            synchronized (monitor) {
                while (monitor.turn != turn) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("THREAD_" + name + ": " + i);

                monitor.switchTurn();
                monitor.notify();
            }
        }
    }
}
