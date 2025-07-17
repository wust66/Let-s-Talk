package com.example;
import java.net.DatagramSocket;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.*;

public class Maincontroller {
    private AnchorPane mainview;
    private DatagramSocket socket;
    private void initSocket() throws UnknownHostException {
        try {
            socket=new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        new RecevierThread().start();
    }
    @FXML
    public TextField IP;
    @FXML
    public TextField PORT;
    @FXML
    public TextField send;
    @FXML
    public void setMainview(AnchorPane mainview) throws SocketException, UnknownHostException {
        this.mainview=mainview;
        initSocket();
    }
    public void handle(ActionEvent event) throws UnknownHostException {
        String ip = IP.getText();
        String portStr = PORT.getText();
        int port = Integer.parseInt(portStr);
        String msg=send.getText();
        byte[] data=msg.getBytes();

            InetAddress addr=InetAddress.getByName(ip);
            DatagramPacket packet =new DatagramPacket(data, data.length,addr,port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发出消息");


    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    class RecevierThread extends Thread{
        @Override
        public void run() {
            System.out.println("启动线程");
            byte[] data=new byte[1024];
            while(true){
                DatagramPacket packet=new DatagramPacket(data,data.length);
                try {
                    socket.receive(packet);
                    int len=packet.getLength();
                    String msg=new String(data,0,len);
                    System.out.println("接收到消息了");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
