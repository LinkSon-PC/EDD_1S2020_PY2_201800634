/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARBOLB;

/**
 *
 * @author Home
 */
public class Pagina {

    private Llave[] _Llave;
    private Pagina[] _Hijos;
    private int K;
    private int Nivel;

    public Pagina() {
        this._Llave = new Llave[5];
        this._Hijos = new Pagina[6];
        this.K = 0;
    }

    public void AgregarLibro(Llave _Libro) {

        for (int k = 0; k < 5; k++) {

            if (this.getLlave()[k] != null) {

                if (this.getLlave()[k].MayorQue(_Libro.getISBM())) {

                    Llave temp, aux = _Libro;

                    for (int i = k; i <= this.getK(); i++) {
                        temp = this.getLlave()[i];
                        this.getLlave()[i] = aux;
                        aux = temp;
                    }

                    this.setK(this.getK() + 1);
                    return;

                } else if (this.getLlave()[k].IgualQue(_Libro.getISBM())) {
                    System.out.println("ISBM YA REGISTRADO");
                    return;
                }

            } else {

                this.getLlave()[k] = _Libro;
                this.setK(this.getK() + 1);
                return;
            }
        }
    }

    public void SepararPagina(int _NodoHijo) {
        //SEPRAR HIJO<_NodoHijo> CON LA CONDICION k>5
        //LLAVE [2] DEL HIJO<_NodoHijo> 
        //AGREGAR A LA PAGINA ACTUAL

//AgregarLibro(this.getHijos()[_NodoHijo].getLlave()[2]);
        Llave temp, aux = this.getHijos()[_NodoHijo].getLlave()[2];

        for (int i = _NodoHijo; i < 5; i++) {
            temp = this.getLlave()[i];
            this.getLlave()[i] = aux;
            aux = temp;
        }

        //AGREGRA NODOS HIJOS AL SPERAR LE NODO
        //SI YA EXISTE CORRER LOS NODOS
        if (this.getHijos()[_NodoHijo + 1] != null) {

            Pagina _Nuevo = new Pagina();

            //AGREGAR LLAVES DEL NUEVO HIJO
            _Nuevo.getLlave()[0] = this.getHijos()[_NodoHijo].getLlave()[3];
            _Nuevo.getLlave()[1] = this.getHijos()[_NodoHijo].getLlave()[4];
            _Nuevo.setK(2);

            //MOVER HIJOS DEL NODO RAIZ AL NUEVO NODO
            _Nuevo.getHijos()[0] = this.getHijos()[_NodoHijo].getHijos()[3];
            _Nuevo.getHijos()[1] = this.getHijos()[_NodoHijo].getHijos()[4];
            _Nuevo.getHijos()[2] = this.getHijos()[_NodoHijo].getHijos()[5];
            //HIJOS DEL NODO A SEPARAR

            //DEZPLASRA NODOS HIJO ACTUALES
            Pagina _Temp, _Aux = _Nuevo;

            for (int k = _NodoHijo + 1; k < 6; k++) {
                _Temp = this.getHijos()[k];
                this.getHijos()[k] = _Aux;
                _Aux = _Temp;
            }

            //ELIMINAR LLAVES/HIJOS DEL NODO HIJO 
        } //SI NO HAY NODO EN HIJO<_NodoHijo + 1> 
        //AGREGAR NUEVO HIJO
        else {
            Pagina _Nuevo = new Pagina();
            this.getHijos()[_NodoHijo + 1] = _Nuevo;

            _Nuevo.getLlave()[0] = this.getHijos()[_NodoHijo].getLlave()[3];
            _Nuevo.getLlave()[1] = this.getHijos()[_NodoHijo].getLlave()[4];
            
            _Nuevo.getHijos()[0] = this.getHijos()[_NodoHijo].getHijos()[3];
            _Nuevo.getHijos()[1] = this.getHijos()[_NodoHijo].getHijos()[4];
            _Nuevo.getHijos()[2] = this.getHijos()[_NodoHijo].getHijos()[5];
            _Nuevo.setK(2);

        }

        this.setK(this.getK() + 1);
        //ELIMINA LLAVES DEL HIJO IZQUIERDO (QUE FUE DIVIDIDO)
        for (int k = 2; k < 5; k++) {
            this.getHijos()[_NodoHijo].getHijos()[k + 1] = null;
            this.getHijos()[_NodoHijo].getLlave()[k] = null;
        }
            this.getHijos()[_NodoHijo].setK(2);
    }

    public boolean VacioHijos() {
        for (Pagina hijo : _Hijos) {
            if (hijo != null) {
                return false;
            }
        }

        return true;
    }

    
    public void EliminarISBM(int _Valor){
        
    }
    
    public String GenerarDot() {
        StringBuilder b = new StringBuilder();

        b.append(getDotName());
        b.append("[label=\"<P0>");
        for (int i = 0; i < this.getK(); i++) {
                b.append("|" + Integer.toString(this.getLlave()[i].getISBM()));
                b.append("|<P" + (i + 1) + ">");
        }

        b.append("\"];\n");

        if(!VacioHijos()){
            
            for (int i = 0; i <= this.getK(); i++) {
                b.append(getDotName() + ":P" + i + " -> " + this.getHijos()[i].getDotName() + ";\n");
                b.append(this.getHijos()[i].GenerarDot());

            }
        }

        return b.toString();

    }

    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    /**
     * @return the _Llave
     */
    public Llave[] getLlave() {
        return _Llave;
    }

    /**
     * @param _Llave the _Llave to set
     */
    public void setLlave(Llave[] _Llave) {
        this.setLlave(_Llave);
    }

    /**
     * @return the _Hijos
     */
    public Pagina[] getHijos() {
        return _Hijos;
    }

    /**
     * @param _Hijos the _Hijos to set
     */
    public void setHijos(Pagina[] _Hijos) {
        this.setHijos(_Hijos);
    }

    /**
     * @return the K
     */
    public int getK() {
        return K;
    }

    /**
     * @param K the K to set
     */
    public void setK(int K) {
        this.K = K;
    }

    /**
     * @return the Nivel
     */
    public int getNivel() {
        return Nivel;
    }

    /**
     * @param Nivel the Nivel to set
     */
    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

}
