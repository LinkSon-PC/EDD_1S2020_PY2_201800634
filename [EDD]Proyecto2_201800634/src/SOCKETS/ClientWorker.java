/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOCKETS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class ClientWorker implements Runnable{

    private Socket socket;
    private DataInputStream inputStrem;
    private DataOutputStream ouputStream;

    public ClientWorker(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStrem = new DataInputStream(this.socket.getInputStream());
        this.ouputStream = new DataOutputStream(this.socket.getOutputStream());
    }
    
    
    @Override
    public void run() {
        boolean isConected=true;
        while (isConected) {            
            try {
                isConected=this.chooseOtions(isConected);
            } catch (IOException ex) {
                Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean chooseOtions(boolean isConected) throws IOException{
        OPTIONS aux=OPTIONS.valueOf(this.inputStrem.readUTF());
        switch(aux){
            case MESSAGE:
                this.mesaage();
                break;
            case CLOSE:
                isConected = false;
                break;
            case PERSONAS:
                break;
        }
        return isConected;
    }
    
    private void mesaage() throws IOException{
        this.ouputStream.writeUTF("CLIENTE CONECTADO A SERVIDOR");
    }
}
