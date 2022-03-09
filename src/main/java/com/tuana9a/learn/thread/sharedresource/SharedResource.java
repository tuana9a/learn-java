package com.tuana9a.learn.thread.sharedresource;

public class SharedResource {
    private int resource;

    public SharedResource() {
        resource = 0;
    }

    public synchronized void increase() {
        resource++;
    }

    public int getResource() {
        return resource;
    }
}
