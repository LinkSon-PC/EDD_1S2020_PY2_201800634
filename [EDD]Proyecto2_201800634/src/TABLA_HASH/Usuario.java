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
public class Usuario {
    private int Carnet;
    private String Nombre;
    private String Apellido;
    private String Carrera;
    private String Password;

    private Usuario Siguiente;
    
    public Usuario() {
    }

    public Usuario(int Carnet, String Nombre, String Apellido, String Carrera, String Password) {
        this.Carnet = Carnet;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Password = Password;
        this.Siguiente = null;
    }

    /**
     * @return the Carnet
     */
    public int getCarnet() {
        return Carnet;
    }

    /**
     * @param Carnet the Carnet to set
     */
    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }
    
    
    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Carrera
     */
    public String getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Siguiente
     */
    public Usuario getSiguiente() {
        return Siguiente;
    }

    /**
     * @param Siguiente the Siguiente to set
     */
    public void setSiguiente(Usuario Siguiente) {
        this.Siguiente = Siguiente;
    }
    
    
}
