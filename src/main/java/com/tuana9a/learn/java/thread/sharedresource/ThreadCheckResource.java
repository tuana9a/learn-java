package com.tuana9a.learn.java.thread.sharedresource;

public class ThreadCheckResource extends ThreadUseResource {

    public ThreadCheckResource(String name, SharedResource resource) {
        super(name, resource);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("THREAD_" + name + ": " + resource.getResource());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
