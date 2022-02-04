package com.tuana9a.learnjava.thread;

public class NormalRunnable implements Runnable {
    String name;

    public NormalRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("THREAD_" + name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=========== END THREAD " + name + " ===============");
    }
}
