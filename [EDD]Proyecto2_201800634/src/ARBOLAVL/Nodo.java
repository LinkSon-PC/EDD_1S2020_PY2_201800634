/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARBOLAVL;

/**
 *
 * @author Home
 */
public class Nodo {

    private String Categoria;
    private int FE;
    private Nodo izquierdo;
    private Nodo derecho;

    private String InOrder;

    public Nodo(String _Categoria) {
        this.Categoria = _Categoria;
        this.FE = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    public String GenerarDot() {
        StringBuilder b = new StringBuilder();

        b.append(InOrder(this,""));

        return b.toString();

    }

    public String InOrder(Nodo _Nodo, String _Dot) {
        if (_Nodo != null) {
            String aux="";
            aux += _Nodo.getDotName() + "[label=\"" + _Nodo.getCategoria() + " \"] \n";
            if (_Nodo.getIzquierdo() != null) {
                aux += _Nodo.getDotName() + "->" + _Nodo.getIzquierdo().getDotName() + "\n";
                aux +=InOrder(_Nodo.getIzquierdo(), aux);
            }
            if (_Nodo.getDerecho()!= null) {
                aux += _Nodo.getDotName() + "->" + _Nodo.getDerecho().getDotName() + "\n";
                aux +=InOrder(_Nodo.getDerecho(), aux);
            }
            return aux;
        }
        return "";
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

}
