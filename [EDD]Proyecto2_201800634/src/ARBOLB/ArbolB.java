/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARBOLB;

import java.io.FileWriter;

/**
 *
 * @author Home
 */
public class ArbolB {

    public Pagina NodoRaíz;
    int Altura;

    public ArbolB() {
        this.Altura = 0;
        this.NodoRaíz = new Pagina();
    }

    public void Agregar(Llave _Libro) {
        if (this.Altura == 0) {
            this.NodoRaíz.AgregarLibro(_Libro);
            this.Altura++;
        } else {
            NodoRaíz = AgregarPagina(NodoRaíz, _Libro);
        }
    }

    public Pagina AgregarPagina(Pagina _Pagina, Llave _Libro) {

        //SI EL NODO RAIZ SUPERA EL LÍMITE
        if (AgregarLlave(_Pagina, _Libro)) {
            System.out.println("INCREMENTO DE NIVEL");

            //NUEVO NODO RAIZ
            Pagina _NuevoRaiz = new Pagina();
            _NuevoRaiz.AgregarLibro(_Pagina.getLlave()[2]);

            Pagina _Nuevo = new Pagina();

            _NuevoRaiz.getHijos()[1] = _Nuevo;

            //MOVER LAS LLAVES DE NODO A NUEVO NODO DERECHA
            for (int k = 3; k < 5; k++) {
                _Nuevo.AgregarLibro(_Pagina.getLlave()[k]);
            }

            //MOVER HIJOS DEL NODO RAIZ AL NUEVO NODO
            for (int k = 0; k < 3; k++) {
                _Nuevo.getHijos()[k] = _Pagina.getHijos()[k + 3];
            }

            //ELIMINA LLAVES DEL HIJO IZQUIERDO (QUE FUE DIVIDIDO)
            _NuevoRaiz.getHijos()[0] = _Pagina;
            for (int k = 2; k < 5; k++) {
                _Pagina.getLlave()[k] = null;
                _Pagina.getHijos()[k + 1] = null;
            }
            _Pagina.setK(2);

            this.Altura++;

            return _NuevoRaiz;
        }

        return _Pagina;
    }

    public boolean AgregarLlave(Pagina _Pagina, Llave _Libro) {

        //SI ES UN NODO HOJA
        if (_Pagina.VacioHijos()) {
            _Pagina.AgregarLibro(_Libro);

            if (_Pagina.getK() >= 5) {
                return true;
            }
        } //SI NO ES UN NODO
        else {

            //SI ES MENOR QUE LA PRIMERA LLAVE INSERTAR EN EL     PRIMER HIJO
            if (_Pagina.getLlave()[0].MayorQue(_Libro.getISBM())) {
                if (AgregarLlave(_Pagina.getHijos()[0], _Libro)) {
                    _Pagina.SepararPagina(0);
                    if (_Pagina.getK() >= 5) {
                        return true;
                    }
                }
                return false;
            } //SI ES MAYOR QUE LA ULTIMA LLAVE INSERTADA  INSERTAR EN EL ULTIMO HIJO DISPONIBLE
            else if (_Pagina.getLlave()[_Pagina.getK() - 1].MenorQue(_Libro.getISBM())) {
                if (AgregarLlave(_Pagina.getHijos()[_Pagina.getK()], _Libro)) {
                    _Pagina.SepararPagina(_Pagina.getK());
                    if (_Pagina.getK() >= 5) {
                        return true;
                    }
                }
                return false;
            } else {

                for (int k = 0; k < _Pagina.getK() - 1; k++) {
                    if (_Pagina.getLlave()[k].MenorQue(_Libro.getISBM()) && _Pagina.getLlave()[k + 1].MayorQue(_Libro.getISBM())) {

                        if (AgregarLlave(_Pagina.getHijos()[k + 1], _Libro)) {
                            _Pagina.SepararPagina(k + 1);
                            if (_Pagina.getK() >= 5) {
                                return true;
                            }
                        }
                        return false;

                    } else if (_Pagina.getLlave()[k].IgualQue(_Libro.getISBM())) {
                        System.out.println("LIBRO YA REGISTRADO EN NODO");
                        return false;
                    }
                }
            }

        }
        return false;

    }

    public String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph g { \n node [shape=record];\n");

        b.append(this.NodoRaíz.GenerarDot());

        b.append("}");

        return b.toString();
    }

    public void GenerarDot() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\archivo.dot";
        String _Img = directorio + "\\archivo.jpg";
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
