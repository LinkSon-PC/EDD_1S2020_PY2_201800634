/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import ARBOLAVL.ArbolAVL;
import ARBOLB.ArbolB;
import ARBOLB.Llave;
import SOCKETS.Server;
import TABLA_HASH.THASH;
import TABLA_HASH.Usuario;
import SOCKETS.Cliente;
import SOCKETS.ClientWorker;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Home
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
//        Random rnd = new Random();
//        
//        THASH Tabla = new THASH();
//        for (int i = 0; i < 40; i++) {
//            Tabla.Agregar(new Usuario(rnd.nextInt(500), "Prueba" +i , "", "", ""));
//        }
//        
//        Tabla.Mostrar_TablaHash();
//        Tabla.GenerarDot();

//        ArbolB _arbol = new ArbolB();
//        for (int i = 0; i < 9; i++) {
//            _arbol.Agregar(new Llave(i , "", "SDF", "", 0, "", "", "", 0));
//        }
//                
//        for (int i = 7; i > -1; i--) {
//            _arbol.Eliminar(i);
//        }
//
//        System.out.println("IMPRIMIR ARBOL B");
//        _arbol.GenerarDot();
//        ArbolAVL avl= new ArbolAVL();
//        avl.Insertar("z");
//        avl.Insertar("a");
//        avl.Insertar("s");
//        avl.Insertar("b");
//        avl.Insertar("m");
//        avl.Insertar("c");
//        avl.Insertar("w");
//        avl.Insertar("e");
//        avl.Insertar("n");
//        avl.Insertar("p");
//        avl.Insertar("o");
//        avl.Insertar("f");
//        avl.Insertar("v");
//        avl.Insertar("r");
//        avl.Insertar("y");
//        avl.Insertar("i");
//        avl.Insertar("ñ");
//        avl.Insertar("l");
//        avl.Eliminar("a");
//        avl.Eliminar("l");
//        avl.Eliminar("y");
//        avl.Eliminar("z");
//        avl.Eliminar("b");
//        avl.Eliminar("s");
//        avl.Eliminar("i");
//        avl.Eliminar("e");
//        avl.Eliminar("w");
//        avl.Eliminar("m");
//        System.out.println(Integer.toString("g".compareToIgnoreCase("h")));
//        System.out.println(Integer.toString("a".compareToIgnoreCase("g")));
//        
//        avl.PreOrder(avl.getRaiz());
//
//        avl.GenerarDot();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADMINISTRADOR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(182, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
            
            LOGIN login=new LOGIN();
            login.setVisible(true);
            this.dispose();
            
                    
//            try {

//            Cliente c = new Cliente();
//            Scanner sc= new Scanner(System.in);
//            String aux="";
//            while (!aux.equalsIgnoreCase("Close")) {
//                System.out.println("ESCRIBA SU OPCION");
//                aux=sc.nextLine();
//                if (aux.equalsIgnoreCase("MESSAGE")) {
//                    System.out.println("MENSAJE DEL SERVIDOR"+ c.recibirMensaje());
//                }
//            }sc.close();
//            c.CerraConexio();
//        } catch (IOException ex) {
//            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            // TODO add your handling code here:
        Administrador admin=new Administrador();
        admin.setVisible(true);
        this.dispose();  

//        try {
//            new Server().startToListen();
//        } catch (IOException ex) {
//            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
        
    }

    public void Cargar() {
        JFileChooser abrir = new JFileChooser();
        abrir.showOpenDialog(abrir);

        try {

        } catch (Exception e) {
        }
    }

    public void lerr() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("usuarios.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);

            JSONArray array = (JSONArray) jsonObject.get("Usuarios");
            System.out.println("");

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("ID: " + jsonObject1.get("id"));
                System.out.println("Nombre: " + jsonObject1.get("nombre"));
                System.out.println("Telefono: " + jsonObject1.get("telefono"));
                System.out.println("Email: " + jsonObject1.get("email"));

                System.out.println("");
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
