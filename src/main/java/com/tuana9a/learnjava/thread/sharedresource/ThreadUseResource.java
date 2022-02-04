package com.tuana9a.learnjava.thread.sharedresource;

public class ThreadUseResource extends Thread {
    String name;
    SharedResource resource;

    public ThreadUseResource(String name, SharedResource resource) {
        this.name = name;
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            resource.increase();
            System.out.println("THREAD_" + name + ": " + resource.getResource());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
