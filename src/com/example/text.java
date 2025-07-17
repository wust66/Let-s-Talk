package com.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class text {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String msg = "测试消息";
        byte[] data = msg.getBytes();
        // 发送到本地的8888端口（确保与接收方端口一致）
        DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getByName("127.0.0.1"), 8888);
        socket.send(packet);
        System.out.println("已发送测试消息到127.0.0.1:8888");
        socket.close();
    }
}