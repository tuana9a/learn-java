package com.tuana9a.os;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;

import static java.nio.file.StandardWatchEventKinds.*;

public class FolderWatcher implements Runnable {
    private volatile boolean stop;
    private final WatchService watcher;
    private final HashMap<String, FileWatcher> items;

    public FolderWatcher(String path) throws IOException {
        this.stop = false;
        this.watcher = FileSystems.getDefault().newWatchService();
        this.items = new HashMap<>();

        Path dir = Paths.get(path);
        dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
    }

    @SafeVarargs
    public final void register(String fileName, Action action, WatchEvent.Kind<Path>... events) throws IOException {
        FileWatcher fileWatcher = new FileWatcher(fileName, action, events);
        items.put(fileName, fileWatcher);
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!stop) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (Exception e) {
                break;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path path = ev.context();
                System.out.println(kind.name() + ": " + path);

                processEvent(kind, path.toString());
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
        stop();
    }

    private void processEvent(WatchEvent.Kind<?> kind, String fileName) {
        FileWatcher fileWatcher = items.get(fileName);
        if (fileWatcher == null) {
            return;
        }

        if (inArray(kind, fileWatcher.events)) {
            fileWatcher.action.perform();
        }
    }

    public void stop() {
        stop = true;
        close(watcher);
    }


    //    SECTION: Helper function
    public <T> boolean inArray(T check, T[] arr) {
        for (T e : arr) {
            if (e.equals(check)) {
                return true;
            }
        }
        return false;
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {
            }
        }
    }

    private static class FileWatcher {
        public String fileName;
        public Action action;
        public WatchEvent.Kind<Path>[] events;

        @SafeVarargs
        public FileWatcher(String fileName, Action action, WatchEvent.Kind<Path>... events) {
            this.fileName = fileName;
            this.action = action;
            this.events = events;
        }

    }
}
