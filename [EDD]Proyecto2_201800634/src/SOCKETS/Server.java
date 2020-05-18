/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOCKETS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Home
 */
public class Server {
    private ServerSocket server;

    public Server() {
        try {
            this.server = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void startToListen() throws IOException{
        while(true){
            Socket cliente = this.server.accept();
            new Thread(new ClientWorker(cliente)).start();
        }
    }
    
}
