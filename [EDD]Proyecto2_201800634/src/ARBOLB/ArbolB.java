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

    private Pagina AgregarPagina(Pagina _Pagina, Llave _Libro) {

        //SI EL NODO RAIZ SUPERA EL LÍMITE
        if (AgregarLlave(_Pagina, _Libro)) {
//            System.out.println("INCREMENTO DE NIVEL");

            //NUEVO NODO RAIZ
            Pagina _NuevoRaiz = new Pagina();
            _NuevoRaiz.getLlave()[0] = _Pagina.getLlave()[2];
            _NuevoRaiz.setK(1);
            //_NuevoRaiz.AgregarLibro(_Pagina.getLlave()[2]);

            Pagina _Nuevo = new Pagina();

            _NuevoRaiz.getHijos()[1] = _Nuevo;

            //MOVER LAS LLAVES DE NODO A NUEVO NODO DERECHA
            _Nuevo.getLlave()[0] = _Pagina.getLlave()[3];
            _Nuevo.getLlave()[1] = _Pagina.getLlave()[4];
            _Nuevo.setK(2);

            //MOVER HIJOS DEL NODO RAIZ AL NUEVO NODO
            _Nuevo.getHijos()[0] = _Pagina.getHijos()[3];
            _Nuevo.getHijos()[1] = _Pagina.getHijos()[4];
            _Nuevo.getHijos()[2] = _Pagina.getHijos()[5];

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

    private boolean AgregarLlave(Pagina _Pagina, Llave _Libro) {

        //SI ES UN NODO HOJA
        if (_Pagina.VacioHijos()) {
            _Pagina.AgregarLibro(_Libro);

            if (_Pagina.getK() >= 5) {
                return true;
            }
        } //SI NO ES UN NODO
        else {

            //SI ES MENOR QUE LA PRIMERA LLAVE INSERTAR EN EL     PRIMER HIJO
            if (_Pagina.getLlave()[0].MayorQue(_Libro.getISBN())) {
                if (AgregarLlave(_Pagina.getHijos()[0], _Libro)) {
                    _Pagina.SepararPagina(0);
                    if (_Pagina.getK() >= 5) {
                        return true;
                    }
                }
                return false;
            } //SI ES MAYOR QUE LA ULTIMA LLAVE INSERTADA  INSERTAR EN EL ULTIMO HIJO DISPONIBLE
            else if (_Pagina.getLlave()[_Pagina.getK() - 1].MenorQue(_Libro.getISBN())) {
                if (AgregarLlave(_Pagina.getHijos()[_Pagina.getK()], _Libro)) {
                    _Pagina.SepararPagina(_Pagina.getK());
                    if (_Pagina.getK() >= 5) {
                        return true;
                    }
                }
                return false;
            } else {

                //INSERTAR EN VALOR INTERMEDIO
                for (int k = 0; k < _Pagina.getK() - 1; k++) {
                    if (_Pagina.getLlave()[k].MenorQue(_Libro.getISBN()) && _Pagina.getLlave()[k + 1].MayorQue(_Libro.getISBN())) {

                        if (AgregarLlave(_Pagina.getHijos()[k + 1], _Libro)) {
                            _Pagina.SepararPagina(k + 1);
                            if (_Pagina.getK() >= 5) {
                                return true;
                            }
                        }
                        return false;

                    } else if (_Pagina.getLlave()[k].IgualQue(_Libro.getISBN())) {
                        System.out.println("LIBRO YA REGISTRADO EN NODO");
                        return false;
                    }
                }
            }

        }
        return false;

    }

    public void Eliminar(int _ISBN) {
        EliminarISBN(_ISBN, NodoRaíz);
        if (NodoRaíz.getK() == 0) {
            NodoRaíz = NodoRaíz.getHijos()[0];
            this.Altura--;
        }
    }

    private void EliminarISBN(int _Valor, Pagina _Pagina) {
        //ELIMINAR EN NODO HOJA
        if (_Pagina.VacioHijos()) {
            for (int k = 0; k < _Pagina.getK(); k++) {
                if (_Pagina.getLlave()[k].IgualQue(_Valor)) {
                    System.out.println("ELIMINADO " + Long.toString(_Pagina.getLlave()[k].getISBN()));

                    for (int i = k; i < _Pagina.getK(); i++) {
                        _Pagina.getLlave()[i] = _Pagina.getLlave()[i + 1];
                    }
                    _Pagina.setK(_Pagina.getK() - 1);
                    return;
                }
            }
        } else {

            for (int k = 0; k < _Pagina.getK(); k++) {
                if (_Pagina.getLlave()[k].IgualQue(_Valor)) {
                    _Pagina.getLlave()[k] = TomarLlave_HijoIzq(_Pagina.getHijos()[k]);

                    Ordenar_HijoIzq(_Pagina);
                    
                    if (_Pagina.getHijos()[k].getK() < 2) {
                    _Pagina.Rebalanceo_Hoja(k);
                        if (_Pagina.getK() == 0) {
                            _Pagina = _Pagina.getHijos()[0];
                        }
                    }
                    return;
                }
                
                else if (_Pagina.getLlave()[k].MayorQue(_Valor)) {
                    EliminarISBN(_Valor, _Pagina.getHijos()[k]);

                    if (_Pagina.getHijos()[k].getK() < 2) {
                    _Pagina.Rebalanceo_Hoja(k);
                        if (_Pagina.getK() == 0) {
                            _Pagina = _Pagina.getHijos()[0];
                        }
                    }
                    return;
                }
            }

            if (_Pagina.getLlave()[_Pagina.getK() - 1].MenorQue(_Valor)) {
                EliminarISBN(_Valor, _Pagina.getHijos()[_Pagina.getK()]);

                if (_Pagina.getHijos()[_Pagina.getK()].getK() < 2) {
                    _Pagina.Rebalanceo_Hoja(_Pagina.getK());
                        if (_Pagina.getK() == 0) {
                            _Pagina = _Pagina.getHijos()[0];
                        }
                    }

            }

            System.out.println("VALOR ISBN " + Integer.toString(_Valor) + " NO ENCONTRADO");

        }

    }

    public Llave TomarLlave_HijoIzq(Pagina _Pagina) {
        if (_Pagina.VacioHijos()) {
            //AUXILIAR PARA RETORNAR
            Llave retorno = _Pagina.getLlave()[_Pagina.getK() - 1];

            //BORRAR EL NODO DE LA HOJA
            _Pagina.getLlave()[_Pagina.getK() - 1] = null;

            //DISMINUSION DE LA CANTIDAD DE LLAVES EN EL NODO
            _Pagina.setK(_Pagina.getK() - 1);
            return retorno;
        } else {
            return TomarLlave_HijoIzq(_Pagina.getHijos()[_Pagina.getK()]);

//            if (_Pagina.getHijos()[_Pagina.getK()].getK() < 2) {
//                _Pagina.Rebalanceo_Hoja(_Pagina.getK());
//
//                if (_Pagina.getK() == 0) {
//                    _Pagina = _Pagina.getHijos()[0];
//                }
//            }
 
        }

    }

    public void Ordenar_HijoIzq(Pagina _Pagina) {
        if (_Pagina.VacioHijos()) {

        } else {
            Ordenar_HijoIzq(_Pagina.getHijos()[_Pagina.getK()]);

            if (_Pagina.getHijos()[_Pagina.getK()].getK() < 2) {
                _Pagina.Rebalanceo_Hoja(_Pagina.getK());

                if (_Pagina.getK() == 0) {
                    _Pagina = _Pagina.getHijos()[0];
                }
            }
//            
        }

    }

    public String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph g { \n node [shape=record];\n");

        if (this.NodoRaíz != null) {
        b.append(this.NodoRaíz.GenerarDot());
            
        }else  System.out.println("ARBOL VACÍO");

        b.append("}");

        return b.toString();
    }

    public void GenerarDot() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\archivoB.dot";
        String _Img = directorio + "\\archivoB.jpg";
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
