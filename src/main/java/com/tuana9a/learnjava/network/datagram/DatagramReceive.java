package com.tuana9a.learnjava.network.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1406);
        byte[] buf = new byte[5];
        DatagramPacket dp = new DatagramPacket(buf, 500);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println(str);
        ds.close();
    }
}
