package com.tuana9a.learn.network.socket;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6969);
        // do something with socket
    }
}
