package com.tuana9a.io.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CmdHelper {
    private final String command;
    private final File workingDir;
    private List<String> results;

    public CmdHelper(String command) {
        this(command, System.getProperty("user.home"));
    }

    public CmdHelper(String command, File workingDir) {
        this.command = command;
        this.workingDir = workingDir;
    }

    public CmdHelper(String command, String workingDir) {
        this(command, new File(workingDir));
    }


    public List<String> exec() throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c " + command, null, workingDir);
        results = getConsoleLog(process);
        return results;
    }

    private List<String> getConsoleLog(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        List<String> results = new LinkedList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            results.add(line);
        }
        return results;
    }

    public List<String> getConsoleLog() {
        return results;
    }

    public void printConsoleLog() {
        for (String s : results) {
            System.out.println(s);
        }
    }
}
