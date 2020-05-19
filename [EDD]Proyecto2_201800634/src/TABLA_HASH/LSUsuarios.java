/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TABLA_HASH;

/**
 *
 * @author Home
 */
public class LSUsuarios {

    public Usuario primero;

    public LSUsuarios() {
        this.primero = null;
    }

    public void Agregar(Usuario _user) {
        if (primero == null) {
            this.primero = _user;
        } else {
            Usuario _aux = this.primero;
            while (_aux.getSiguiente() != null) {
                _aux = _aux.getSiguiente();
            }
            _aux.setSiguiente(_user);
        }
    }

    public String MostrarLista() {
        String lista = "";
        Usuario _aux = this.primero;

        while (_aux != null) {
            lista += "|\t" + _aux.getNombre() + "," + _aux.getCarnet() + "\t|";
            _aux = _aux.getSiguiente();
        }
        return lista;
    }

    public String getDot() {
        StringBuilder lista = new StringBuilder();
        Usuario _aux = this.primero;

        lista.append("subgraph cluster_"+this.hashCode()+" {  node[shape=Msquare  color = darkslategray text=white gradientangle=90]; \n");
        while (_aux != null) {

            lista.append(_aux.hashCode() + "[label=\"" + _aux.getString() + "\"]\n");
            
            if (_aux.getSiguiente() != null) {
                lista.append(_aux.hashCode() + "->" + _aux.getSiguiente().hashCode() +  "\n");
            }
            _aux = _aux.getSiguiente();
        }
        lista.append("}");
        return lista.toString();
    }

    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    /**
     * @return the primero
     */
    public Usuario getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Usuario primero) {
        this.primero = primero;
    }

}
