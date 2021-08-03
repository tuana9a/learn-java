package com.tuana9a.network.datagram;

import java.io.IOException;
import java.net.*;

public class DatagramSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String data = "Hello Mother Fucker";

        DatagramPacket dp = new DatagramPacket(data.getBytes(),data.length(), InetAddress.getByName("14.177.23.92"),1406);

        ds.send(dp);
        ds.close();
    }
}
