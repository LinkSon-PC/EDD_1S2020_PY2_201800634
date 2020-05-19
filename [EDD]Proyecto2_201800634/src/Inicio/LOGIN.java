/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import ARBOLAVL.ArbolAVL;
import ARBOLAVL.Nodo;
import ARBOLB.Llave;
import TABLA_HASH.THASH;
import TABLA_HASH.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Home
 */
public class LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public LOGIN() {
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

        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USER");

        jLabel2.setText("PASSWORD");

        jButton1.setText("INICIAR SESION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Abrir");

        jMenuItem1.setText("Agregar Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Agregar Libros");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user)
                            .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        try {
//            Sesion._User = Sesion._TablaHash.Buscar_Usuario(Long.parseLong(user.getText()));
//            if (Sesion._User != null) {
//                if (Sesion._User.getPassword().compareTo(pass.getText()) == 0) {
//                    _cUsuario user = new _cUsuario();
//                    user.setVisible(true);
//                    this.dispose();
//                } else {
//                    Sesion._User = null;
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "CARNET NO ENCOTRADO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (Exception e) {
//        }

        _cUsuario user=new _cUsuario();
            user.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String aux = "";
        String texto = "";
        String Ruta = "";

        /**
         * llamamos el metodo que permite cargar la ventana
         */
        JFileChooser JfC = new JFileChooser();
        JfC.setAcceptAllFileFilterUsed(false);
        JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *.json", "json"));
        JfC.setCurrentDirectory(new File("Escritorio"));
        JfC.showOpenDialog(null);
        /**
         * abrimos el archivo seleccionado
         */
        File Archivo = JfC.getSelectedFile();
        if (Archivo != null) {
            Ruta = "" + Archivo;

            leerUsuarios(Ruta);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String aux = "";
        String texto = "";
        String Ruta = "";

        /**
         * llamamos el metodo que permite cargar la ventana
         */
        JFileChooser JfC = new JFileChooser();
        JfC.setAcceptAllFileFilterUsed(false);
        JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *.json", "json"));
        JfC.setCurrentDirectory(new File("Escritorio"));
        JfC.showOpenDialog(null);
        /**
         * abrimos el archivo seleccionado
         */
        File Archivo = JfC.getSelectedFile();
        if (Archivo != null) {
            Ruta = "" + Archivo;

            leerLibros(Ruta);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void leerUsuarios(String _direccion) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(_direccion));
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(_direccion), "UTF-8"));
            System.out.println("JSON LEIDO: " + jsonObject);

            JSONArray array = (JSONArray) jsonObject.get("Usuarios");
            System.out.println("");

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("ID: " + jsonObject1.get("Carnet"));
                System.out.println("Nombre: " + jsonObject1.get("Nombre"));
                System.out.println("Telefono: " + jsonObject1.get("Apellido"));
                System.out.println("Email: " + jsonObject1.get("Carrera"));
                System.out.println("Email: " + jsonObject1.get("Password"));

                Sesion._TablaHash.Agregar(new Usuario(Integer.parseInt(jsonObject1.get("Carnet").toString()), jsonObject1.get("Nombre").toString(), jsonObject1.get("Apellido").toString(),
                        jsonObject1.get("Carrera").toString(), jsonObject1.get("Password").toString()));

                System.out.println("");
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }

        Sesion._TablaHash.Mostrar_TablaHash();
        Sesion._TablaHash.GenerarDot();
    }

    public void leerLibros(String _direccion) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(_direccion));
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(_direccion), "UTF-8"));
//            System.out.println("JSON LEIDO: " + jsonObject);

            JSONArray array = (JSONArray) jsonObject.get("libros");
            System.out.println("");

            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DE LIBROS: " + i);
                System.out.println("ISBM: " + jsonObject1.get("ISBN"));
                System.out.println("AÑO: " + jsonObject1.get("Año"));
                System.out.println("IDIOMA: " + jsonObject1.get("Idioma"));
                System.out.println("TITULO: " + jsonObject1.get("Titulo"));
                System.out.println("EDITORIAL: " + jsonObject1.get("Editorial"));
                System.out.println("AUTOR: " + jsonObject1.get("Autor"));
                System.out.println("EDICION: " + jsonObject1.get("Edicion"));
                System.out.println("CATEGORIA: " + jsonObject1.get("Categoria"));

                Sesion._ArbolAVL.Insertar(jsonObject1.get("Categoria").toString(), 0);
                Sesion._ArbolAVL.AgregarLibro(jsonObject1.get("Categoria").toString(), new Llave(Long.parseLong(jsonObject1.get("ISBN").toString()), jsonObject1.get("Titulo").toString(), jsonObject1.get("Autor").toString(),
                        jsonObject1.get("Editorial").toString(), Integer.parseInt(jsonObject1.get("Año").toString()), jsonObject1.get("Edicion").toString(), jsonObject1.get("Categoria").toString(),
                        jsonObject1.get("Idioma").toString(), 0));

            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }
//        Sesion._ArbolAVL.PreOrder(Sesion._ArbolAVL.getRaiz());
//
//        Sesion._ArbolAVL.GenerarDot();

//        Nodo _Nodo = Sesion._ArbolAVL.Buscar("Informativos", Sesion._ArbolAVL.getRaiz());
//        if (_Nodo != null) {
//            _Nodo.getArbolB().GenerarDot();
//        }

    }

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}