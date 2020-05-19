
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARBOLAVL;

import ARBOLB.Llave;
import java.io.FileWriter;

/**
 *
 * @author Home
 */
public class ArbolAVL {

    private Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public Nodo Buscar(String _Categoria, Nodo _Nodo) {
        if (_Nodo != null) {
            if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) > 0) {
                return Buscar(_Categoria, _Nodo.getDerecho());
            } else if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) < 0) {
                return Buscar(_Categoria, _Nodo.getIzquierdo());
            } else {
                return _Nodo;
            }
        }
        System.out.println("CATEGORÍA NO ENCONTRADA");
        return null;
    }

    public void AgregarLibro(String _Categoria, Llave _Llave) {
        AgregarLibro_ArbolB(_Categoria, this.raiz, _Llave);
    }

    private void AgregarLibro_ArbolB(String _Categoria, Nodo _Nodo, Llave _Llave) {
        if (_Nodo != null) {
            if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) > 0) {
                AgregarLibro_ArbolB(_Categoria, _Nodo.getDerecho(), _Llave);
            } else if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) < 0) {
                AgregarLibro_ArbolB(_Categoria, _Nodo.getIzquierdo(), _Llave);
            } else {
                System.out.println("LIBRO INGRESADO EN :" + _Nodo.getCategoria());
                _Nodo.getArbolB().Agregar(_Llave);
            }
        }
    }

    public void Insertar(String _Categoria, long _Carnet) {
        if (this.raiz == null) {
            this.raiz = new Nodo(_Categoria, _Carnet);
        } else {
            this.raiz = InsertarAVL(_Categoria, _Carnet, getRaiz());
        }
    }

    private Nodo InsertarAVL(String _Categoria, long _Carnet, Nodo _Nodo) {
        Nodo _Aux = _Nodo;
        if (_Nodo != null) {

            if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) > 0) {
//                System.out.println("NODO 1");
                _Nodo.setDerecho(InsertarAVL(_Categoria, _Carnet, _Nodo.getDerecho()));
                if ((Obtener_FE(_Nodo.getDerecho()) - Obtener_FE(_Nodo.getIzquierdo())) == 2) {

                    if (_Categoria.compareToIgnoreCase(_Nodo.getDerecho().getCategoria()) > 0) {
                        _Aux = RSD(_Nodo);
                    } else {
                        _Aux = RDD(_Nodo);
                    }

                }
            } else if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) < 0) {

//                System.out.println("NODO -1");
                _Nodo.setIzquierdo(InsertarAVL(_Categoria, _Carnet, _Nodo.getIzquierdo()));
                if ((Obtener_FE(_Nodo.getIzquierdo()) - Obtener_FE(_Nodo.getDerecho())) == 2) {

                    if (_Categoria.compareToIgnoreCase(_Nodo.getIzquierdo().getCategoria()) < 0) {
                        _Aux = RSI(_Nodo);
                    } else {
                        _Aux = RDI(_Nodo);
                    }
                }
            } else {
//                System.out.println("NODO REPETIDO");
                return _Nodo;
            }

            if (_Nodo.getIzquierdo() == null && _Nodo.getDerecho() != null) {
                _Nodo.setFE(_Nodo.getDerecho().getFE() + 1);
            } else if (_Nodo.getIzquierdo() != null && _Nodo.getDerecho() == null) {
                _Nodo.setFE(_Nodo.getIzquierdo().getFE() + 1);
            } else {
                _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
            }

            return _Aux;
        }
        Nodo _Nuevo = new Nodo(_Categoria, _Carnet);
        _Nuevo.setFE(Math.max(Obtener_FE(_Nuevo.getIzquierdo()), Obtener_FE(_Nuevo.getDerecho())) + 1);
        return _Nuevo;
    }

    public void Eliminar(String _Categoría) {
        if (this.raiz != null) {
            this.raiz = EliminarNodo(_Categoría, this.raiz);
        } else {
            System.out.println("ARBOL AVL VACÍO");
        }
        System.out.println("hola");
    }

    private Nodo EliminarNodo(String _Categoria, Nodo _Nodo) {
        Nodo _Aux = _Nodo;
        if (_Nodo != null) {
            if (!_Nodo.NoHijos()) {
                if (_Nodo.getCategoria().compareToIgnoreCase(_Categoria) == 0) {
                    System.out.println("ELIMINAR NODO" + _Nodo.getCategoria());

                    if (_Nodo.getIzquierdo() != null) {
                        if (_Nodo.getIzquierdo().getDerecho() == null) {
                            _Aux = _Nodo.getIzquierdo();
                        } else {

                            if (_Nodo.getIzquierdo().getDerecho().NoHijos()) {
                                _Aux = _Nodo.getIzquierdo().getDerecho();
                                _Nodo.getIzquierdo().setDerecho(null);
                            } else {
                                _Aux = Mayor_Izquierda(_Nodo.getIzquierdo().getDerecho());
                            }

                            _Aux.setIzquierdo(_Nodo.getIzquierdo());
                        }
                        _Aux.setDerecho(_Nodo.getDerecho());

                    } else if (_Nodo.getDerecho() != null) {

                        if (_Nodo.getDerecho().getIzquierdo() == null) {
                            _Aux = _Nodo.getDerecho();
                        } else {

                            if (_Nodo.getDerecho().getIzquierdo().NoHijos()) {
                                _Aux = _Nodo.getDerecho().getIzquierdo();
                                _Nodo.getDerecho().setIzquierdo(null);
                            } else {
                                _Aux = Menor_Derecha(_Nodo.getDerecho().getIzquierdo());
                            }

                            _Aux.setDerecho(_Nodo.getDerecho());
                        }
                        _Aux.setIzquierdo(_Nodo.getIzquierdo());
                    }

                } else if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) < 0) {
//                    System.out.println("IZQUIERDA");
                    _Aux.setIzquierdo(EliminarNodo(_Categoria, _Nodo.getIzquierdo()));
                } else if (_Categoria.compareToIgnoreCase(_Nodo.getCategoria()) > 0) {
//                    System.out.println("DERECHA");
                    _Aux.setDerecho(EliminarNodo(_Categoria, _Nodo.getDerecho()));
                }

                if (_Nodo.getIzquierdo() == null && _Nodo.getDerecho() != null) {
                    _Aux.setFE(_Nodo.getDerecho().getFE() + 1);
                } else if (_Nodo.getIzquierdo() != null && _Nodo.getDerecho() == null) {
                    _Aux.setFE(_Nodo.getIzquierdo().getFE() + 1);
                } else {
                    _Aux.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
                }

            } else {
                if (_Nodo.getCategoria().compareToIgnoreCase(_Categoria) == 0) {
                    return null;
                } else {
                    return _Nodo;
                }
            }

            return Reajustar(_Aux);
        }

        return null;
    }

    private Nodo Mayor_Izquierda(Nodo _Nodo) {
        Nodo _Aux = _Nodo;

        if (_Nodo.getIzquierdo() != null && _Nodo.getDerecho() == null) {
            _Nodo = _Nodo.getIzquierdo();
        } else if (_Nodo.getDerecho() != null) {
            if (_Nodo.getDerecho().NoHijos()) {
                _Aux = _Nodo.getDerecho();
                _Nodo.setDerecho(null);
            } else {
                _Aux = Mayor_Izquierda(_Nodo.getDerecho());
            }
        }

        if (_Aux.getIzquierdo() == null && _Aux.getDerecho() != null) {
            _Aux.setFE(_Nodo.getDerecho().getFE() + 1);
        } else if (_Aux.getIzquierdo() != null && _Aux.getDerecho() == null) {
            _Aux.setFE(_Nodo.getIzquierdo().getFE() + 1);
        } else {
            _Aux.setFE(Math.max(Obtener_FE(_Aux.getIzquierdo()), Obtener_FE(_Aux.getDerecho())) + 1);
        }
        return _Aux;
    }

    private Nodo Menor_Derecha(Nodo _Nodo) {
        Nodo _Aux = _Nodo;

        if (_Nodo.getIzquierdo() == null && _Nodo.getDerecho() != null) {
            _Nodo = _Nodo.getIzquierdo();
        } else if (_Nodo.getIzquierdo() != null) {
            if (_Nodo.getIzquierdo().NoHijos()) {
                _Aux = _Nodo.getIzquierdo();
                _Nodo.setIzquierdo(null);
            } else {
                _Aux = Menor_Derecha(_Nodo.getIzquierdo());
            }
        }

        if (_Aux.getIzquierdo() == null && _Aux.getDerecho() != null) {
            _Aux.setFE(_Nodo.getDerecho().getFE() + 1);
        } else if (_Aux.getIzquierdo() != null && _Aux.getDerecho() == null) {
            _Aux.setFE(_Nodo.getIzquierdo().getFE() + 1);
        } else {
            _Aux.setFE(Math.max(Obtener_FE(_Aux.getIzquierdo()), Obtener_FE(_Aux.getDerecho())) + 1);
        }
        return _Aux;
    }

    private Nodo Reajustar(Nodo _Nodo) {
        Nodo _Aux = _Nodo;

        if ((Obtener_FE(_Nodo.getDerecho()) - Obtener_FE(_Nodo.getIzquierdo())) == 2) {

            if (_Nodo.getFE() > 0) {
                _Aux = RSD(_Nodo);
            } else {
                _Aux = RDD(_Nodo);
            }

        }
        if ((Obtener_FE(_Nodo.getIzquierdo()) - Obtener_FE(_Nodo.getDerecho())) == 2) {

            if (_Nodo.getFE() < 0) {
                _Aux = RSI(_Nodo);
            } else {
                _Aux = RDI(_Nodo);
            }
        }

        if (_Nodo.getIzquierdo() == null && _Nodo.getDerecho() != null) {
            _Nodo.setFE(_Nodo.getDerecho().getFE() + 1);
        } else if (_Nodo.getIzquierdo() != null && _Nodo.getDerecho() == null) {
            _Nodo.setFE(_Nodo.getIzquierdo().getFE() + 1);
        } else {
            _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
        }
        return _Aux;
    }

    private int Obtener_FE(Nodo _Nodo) {
        if (_Nodo != null) {
            return _Nodo.getFE();
        }
        return -1;
    }

    private Nodo RSI(Nodo _Nodo) {
        Nodo _aux = _Nodo.getIzquierdo();
        _Nodo.setIzquierdo(_aux.getDerecho());
        _aux.setDerecho(_Nodo);
        _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
        _aux.setFE(Math.max(Obtener_FE(_aux.getIzquierdo()), Obtener_FE(_aux.getDerecho())) + 1);

        return _aux;
    }

    private Nodo RSD(Nodo _Nodo) {
        Nodo _aux = _Nodo.getDerecho();
        _Nodo.setDerecho(_aux.getIzquierdo());
        _aux.setIzquierdo(_Nodo);
        _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
        _aux.setFE(Math.max(Obtener_FE(_aux.getIzquierdo()), Obtener_FE(_aux.getDerecho())) + 1);

        return _aux;
    }

    private Nodo RDI(Nodo _Nodo) {
        Nodo _aux;
        _Nodo.setIzquierdo(RSD(_Nodo.getIzquierdo()));
        _aux = RSI(_Nodo);
        return _aux;
    }

    private Nodo RDD(Nodo _Nodo) {
        Nodo _aux;
        _Nodo.setDerecho(RSI(_Nodo.getDerecho()));
        _aux = RSD(_Nodo);
        return _aux;
    }

    public void PreOrder(Nodo _Nodo) {
        if (_Nodo != null) {
            System.out.print(_Nodo.getCategoria() + "\t");
            PreOrder(_Nodo.getIzquierdo());
            PreOrder(_Nodo.getDerecho());
        }
    }

    public void InOrder(Nodo _Nodo) {
        if (_Nodo != null) {
            InOrder(_Nodo.getIzquierdo());
            System.out.print(_Nodo.getCategoria() + "\t");
            InOrder(_Nodo.getDerecho());
        }
    }

    public void PostOrder(Nodo _Nodo) {
        if (_Nodo != null) {
            PostOrder(_Nodo.getIzquierdo());
            PostOrder(_Nodo.getDerecho());
            System.out.print(_Nodo.getCategoria() + "\t");
        }
    }

    private String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph G { style = filled; bgcolor = white; color = lightgrey; node[shape=box3d, style = filled]");

        if (this.raiz != null) {
            b.append(raiz.GenerarDot());

        } else {
            System.out.println("ARBOL VACÍO");
        }

        b.append("}");

        return b.toString();
    }
    private String toPreOrder() {
        StringBuilder b = new StringBuilder();

        b.append("digraph G {    rankdir = LR;  style = filled; bgcolor = white; color = lightgrey; node[shape=box3d, style = filled]");

        if (this.raiz != null) {
            b.append(raiz.GenerarPreOrder());

        } else {
            System.out.println("ARBOL VACÍO");
        }

        b.append("}");

        return b.toString();
    }
    private String toInOrder() {
        StringBuilder b = new StringBuilder();

        b.append("digraph G {    rankdir = LR;  style = filled; bgcolor = white; color = lightgrey; node[shape=box3d, style = filled]");

        if (this.raiz != null) {
            b.append(raiz.GenerarInOrder());

        } else {
            System.out.println("ARBOL VACÍO");
        }

        b.append("}");

        return b.toString();
    }
    private String toPostOrder() {
        StringBuilder b = new StringBuilder();

        b.append("digraph G {     rankdir = LR;  style = filled; bgcolor = white; color = lightgrey; node[shape=box3d, style = filled]");

        if (this.raiz != null) {
            b.append(raiz.GenerarPostOrder());

        } else {
            System.out.println("ARBOL VACÍO");
        }

        b.append("}");

        return b.toString();
    }

    public void GenerarDot() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\avl.dot";
        String _Img = directorio + "\\avl.jpg";
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

    public void GenerarPreOrder() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\avlPre.dot";
        String _Img = directorio + "\\avlPre.jpg";
        try {

            FileWriter f = new FileWriter(_Dot);

            f.write(toPreOrder());

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

    public void GenerarInOrder() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\avlIn.dot";
        String _Img = directorio + "\\avlIn.jpg";
        try {

            FileWriter f = new FileWriter(_Dot);

            f.write(toInOrder());

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

    public void GenerarPostOrder() {
        String directorio = System.getProperty("user.dir");

        String _Dot = directorio + "\\avlPost.dot";
        String _Img = directorio + "\\avlPost.jpg";
        try {

            FileWriter f = new FileWriter(_Dot);

            f.write(toPostOrder());

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

    /**
     * @return the raiz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
