/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARBOLAVL;

import ARBOLB.ArbolB;

/**
 *
 * @author Home
 */
public class Nodo {

    private String Categoria;
    private long Carnet;
    private ArbolB ArbolB;
    private int FE;
    private Nodo izquierdo;
    private Nodo derecho;

    
    public Nodo(String _Categoria, long Carnet) {
        this.Categoria = _Categoria;
        this.Carnet = Carnet;
        this.ArbolB = new ArbolB();
        this.FE = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    public String GenerarDot() {
        StringBuilder b = new StringBuilder();

        b.append(Avl(this,""));

        return b.toString();

    }
    public String GenerarPreOrder() {
        StringBuilder b = new StringBuilder();

        b.append(PreOrder(this,""));

        return b.toString();

    }
    public String GenerarInOrder() {
        StringBuilder b = new StringBuilder();

        b.append(InOrder(this,""));

        return b.toString();

    }
    public String GenerarPostOrder() {
        StringBuilder b = new StringBuilder();

        b.append(PostOrder(this,""));

        return b.toString();

    }

    private String Avl(Nodo _Nodo, String _Dot) {
        if (_Nodo != null) {
            String aux="";
            aux += _Nodo.getDotName() + "[label=\"" + _Nodo.getCategoria() +"\n"+ _Nodo.getCarnet() + " \"] \n";
            if (_Nodo.getIzquierdo() != null) {
                aux += _Nodo.getDotName() + "->" + _Nodo.getIzquierdo().getDotName() + "\n";
                aux +=Avl(_Nodo.getIzquierdo(), aux);
            }
            if (_Nodo.getDerecho()!= null) {
                aux += _Nodo.getDotName() + "->" + _Nodo.getDerecho().getDotName() + "\n";
                aux +=Avl(_Nodo.getDerecho(), aux);
            }
            return aux;
        }
        return "";
    }
    
    private String PreOrder(Nodo _Nodo, String _Dot){
        
        if (_Nodo != null) {
            String aux="";
            aux += _Nodo.getDotName() + "[label=\"" + _Nodo.getCategoria() +"\n"+ _Nodo.getCarnet() + " \"] \n";
            if (_Nodo.getIzquierdo() != null) {
                aux +=PreOrder(_Nodo.getIzquierdo(), aux);
            }
            if (_Nodo.getDerecho()!= null) {
                aux +=PreOrder(_Nodo.getDerecho(), aux);
            }
            return aux;
        }
        return "";
    }
    private String InOrder(Nodo _Nodo, String _Dot){
        
        if (_Nodo != null) {
            String aux="";
            if (_Nodo.getIzquierdo() != null) {
                aux +=InOrder(_Nodo.getIzquierdo(), aux);
            }
            aux += _Nodo.getDotName() + "[label=\"" + _Nodo.getCategoria() +"\n"+ _Nodo.getCarnet() + " \"] \n";
            if (_Nodo.getDerecho()!= null) {
                aux +=InOrder(_Nodo.getDerecho(), aux);
            }
            return aux;
        }
        return "";
    }
    private String PostOrder(Nodo _Nodo, String _Dot){
        
        if (_Nodo != null) {
            String aux="";
            if (_Nodo.getIzquierdo() != null) {
                aux +=PostOrder(_Nodo.getIzquierdo(), aux);
            }
            if (_Nodo.getDerecho()!= null) {
                aux +=PostOrder(_Nodo.getDerecho(), aux);
            }
            aux += _Nodo.getDotName() + "[label=\"" + _Nodo.getCategoria() +"\n"+ _Nodo.getCarnet() + " \"] \n";
            return aux;
        }
        return "";
    }

    public boolean NoHijos(){
        if (getDerecho()== null && getIzquierdo()==null) {
            return true;
        }
        return false;
    }
    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the FE
     */
    public int getFE() {
        return FE;
    }

    /**
     * @param FE the FE to set
     */
    public void setFE(int FE) {
        this.FE = FE;
    }

    /**
     * @return the izquierdo
     */
    public Nodo getIzquierdo() {
        return izquierdo;
    }

    /**
     * @param izquierdo the izquierdo to set
     */
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * @return the derecho
     */
    public Nodo getDerecho() {
        return derecho;
    }

    /**
     * @param derecho the derecho to set
     */
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    /**
     * @return the ArbolB
     */
    public ArbolB getArbolB() {
        return ArbolB;
    }

    /**
     * @param ArbolB the ArbolB to set
     */
    public void setArbolB(ArbolB ArbolB) {
        this.ArbolB = ArbolB;
    }

    /**
     * @return the Carnet
     */
    public long getCarnet() {
        return Carnet;
    }

    /**
     * @param Carnet the Carnet to set
     */
    public void setCarnet(long Carnet) {
        this.Carnet = Carnet;
    }

}
