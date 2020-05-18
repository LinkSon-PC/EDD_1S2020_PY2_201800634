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
public class Cliente {
    private Socket sokect;
    private DataInputStream inputStream;
    private DataOutputStream ouputStream;

    public Cliente() throws IOException {
        try {
            
        this.sokect = new Socket("localhost", 5000);
        this.inputStream = new DataInputStream(this.sokect.getInputStream());
        this.ouputStream = new DataOutputStream(this.sokect.getOutputStream());
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String recibirMensaje() {
        String fromServer="";
        
        try{
            
        this.ouputStream.writeUTF(OPTIONS.MESSAGE.toString());
        fromServer = this.inputStream.readUTF();
        }catch(IOException e){
            
        }
        
        return fromServer;
    }
    
    public void CerraConexio(){
        try {
            this.ouputStream.writeUTF(OPTIONS.CLOSE.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
