package com.tuana9a.learn.java.network.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6969);
        while (true) {
            Socket socket = server.accept();
            // do something with socket
        }
    }
}
