/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLA_HASH;

import java.io.FileWriter;

/**
 *
 * @author Home
 */
public class THASH {
    private LSUsuarios[] TablaHash;

    public THASH() {
        TablaHash = new LSUsuarios[45];
    }
    
    public void Agregar(Usuario _user){
        int _hash = _user.getCarnet() % 45;
        
        if (TablaHash[_hash]==null) {
            TablaHash[_hash] = new LSUsuarios();
            TablaHash[_hash].Agregar(_user);
        }else{
            TablaHash[_hash].Agregar(_user);
        }
    }
    
    public void Mostrar_TablaHash(){
        for (int i = 0; i < TablaHash.length; i++) {
            if (TablaHash[i]!=null) {
            System.out.println("====================================");
                System.out.println(" INDEX :" + i + " " + TablaHash[i].MostrarLista()) ;
            System.out.println("");
            }
        }
    }
    
    
    private String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph G { \n");
        b.append(" node[shape=Msquare  color = darkslategray text=white gradientangle=90];");

        for (int i = 0; i < TablaHash.length; i++) {
            if (TablaHash[i]!=null) {
               b.append(TablaHash[i].getDotName()+"[label =\" Modulo "+ i +"\"] \n");  
               b.append(TablaHash[i].getDot());
               b.append(TablaHash[i].getDotName()+"->"+ TablaHash[i].primero.hashCode() + "\n");
            }
        }

        b.append("} ");

        return b.toString();
    }
    
    public void GenerarDot() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\THash.dot";
        String _Img = directorio + "\\THash.jpg";
        try {

            FileWriter f = new FileWriter(_Dot);

            f.write(toDot());

            f.close();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

        try {

            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tjpg";
            cmd[2] = _Dot;
            cmd[3] = "-o";
            cmd[4] = _Img;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

        try {

            String[] cmd = new String[4];
            cmd[0] = "cmd";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = _Img;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }

    
}
