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
public class ArbolAVL {

    private Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public Nodo Buscar(String _Categoria, Nodo _Nodo) {
        if (_Nodo != null) {
            switch (_Nodo.getCategoria().compareToIgnoreCase(_Categoria)) {
                case 1:
                    return Buscar(_Categoria, _Nodo.getDerecho());
                case -1:
                    return Buscar(_Categoria, _Nodo.getIzquierdo());
                default:
                    return _Nodo;
            }
        }
        System.out.println("CATEGORÍA NO ENCONTRADA");
        return null;
    }

    public void Insertar(String _Categoria){
        if(this.getRaiz() == null){
            this.setRaiz(new Nodo(_Categoria));
        }else{
            this.setRaiz(InsertarAVL(_Categoria, getRaiz()));
        }
    }
    
    private Nodo InsertarAVL(String _Categoria, Nodo _Nodo) {
        Nodo _Aux, _Nuevo = new Nodo(_Categoria);
        if (_Nodo != null) {

            switch (_Nodo.getCategoria().compareToIgnoreCase(_Categoria)) {
                case 1:
                    _Nodo.setDerecho(InsertarAVL(_Categoria, _Nodo.getDerecho()));
                    if ((Obtener_FE(_Nodo.getDerecho()) - Obtener_FE(_Nodo.getIzquierdo())) == 2) {
                        if (_Nodo.getDerecho().getCategoria().compareToIgnoreCase(_Categoria) == 1) {
                            _Aux = RSD(_Nodo);
                        } else {
                            _Aux = RDD(_Nodo);
                        }
                    }

                case -1:
                    _Nodo.setIzquierdo(InsertarAVL(_Categoria, _Nodo.getIzquierdo()));
                    if ((Obtener_FE(_Nodo.getIzquierdo()) - Obtener_FE(_Nodo.getDerecho())) == 2) {
                        if (_Nodo.getIzquierdo().getCategoria().compareToIgnoreCase(_Categoria) == -1) {
                            _Aux = RSI(_Nodo);
                        } else {
                            _Aux = RDI(_Nodo);
                        }
                    }
                default:
                    _Aux = _Nodo;
            }
            
            if (_Nodo.getIzquierdo()== null && _Nodo.getDerecho()!= null) {
                _Nodo.setFE(_Nodo.getDerecho().getFE()+1);
            }else if (_Nodo.getIzquierdo()!= null && _Nodo.getDerecho()== null) {
                _Nodo.setFE(_Nodo.getIzquierdo().getFE()+1);                
            }else{
                _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho()))+1);
            }
            
            return _Aux;
        }
        return _Nuevo;
    }

    private int Obtener_FE(Nodo _Nodo) {
        if (_Nodo != null) {
            return _Nodo.getFE();
        }
        return -1;
    }

    public Nodo RSI(Nodo _Nodo) {
        Nodo _aux = _Nodo.getIzquierdo();
        _Nodo.setIzquierdo(_aux.getDerecho());
        _aux.setDerecho(_aux);
        _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
        _aux.setFE(Math.max(Obtener_FE(_aux.getIzquierdo()), Obtener_FE(_aux.getDerecho())) + 1);

        return _aux;
    }

    public Nodo RSD(Nodo _Nodo) {
        Nodo _aux = _Nodo.getDerecho();
        _Nodo.setDerecho(_aux.getIzquierdo());
        _aux.setIzquierdo(_Nodo);
        _Nodo.setFE(Math.max(Obtener_FE(_Nodo.getIzquierdo()), Obtener_FE(_Nodo.getDerecho())) + 1);
        _aux.setFE(Math.max(Obtener_FE(_aux.getIzquierdo()), Obtener_FE(_aux.getDerecho())) + 1);

        return _aux;
    }

    public Nodo RDI(Nodo _Nodo) {
        Nodo _aux;
        _Nodo.setIzquierdo(RSD(_Nodo.getIzquierdo()));
        _aux = RSI(_Nodo);
        return _aux;
    }

    public Nodo RDD(Nodo _Nodo) {
        Nodo _aux;
        _Nodo.setDerecho(RSI(_Nodo.getDerecho()));
        _aux = RSD(_Nodo);
        return _aux;
    }

    
    public void PreOrder(Nodo _Nodo){
        if(_Nodo != null){
            PreOrder(_Nodo.getIzquierdo());
            System.out.println(_Nodo.getCategoria());
            PreOrder(_Nodo.getDerecho());
        }
    }
    
    public void InOrder(Nodo _Nodo){
        if(_Nodo != null){
            System.out.println(_Nodo.getCategoria());
            InOrder(_Nodo.getIzquierdo());
            InOrder(_Nodo.getDerecho());
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
