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
public class Llave {
    private int ISBM;
    private String Título;
    private String Autor;
    private String Editorial;
    private int Anio;
    private String Edición;
    private String Categoría;
    private String Idioma;
    private int Carnet;

    public Llave() {
    }

    public Llave(int ISBM, String Título, String Autor, String Editorial, int Anio, String Edición, String Categoría, String Idioma, int Carnet) {
        this.ISBM = ISBM;
        this.Título = Título;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.Anio = Anio;
        this.Edición = Edición;
        this.Categoría = Categoría;
        this.Idioma = Idioma;
        this.Carnet = Carnet;
    }

    
    
    public boolean MenorQue(int _Valor){
        return getISBM()<_Valor;
    }
    public boolean MayorQue(int _Valor){
        return getISBM()>_Valor;
    }
    public boolean IgualQue(int _Valor){
        return getISBM()==_Valor;
    }
    /**
     * @return the Título
     */
    public String getTítulo() {
        return Título;
    }

    /**
     * @param Título the Título to set
     */
    public void setTítulo(String Título) {
        this.Título = Título;
    }

    /**
     * @return the Autor
     */
    public String getAutor() {
        return Autor;
    }

    /**
     * @param Autor the Autor to set
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    /**
     * @return the Editorial
     */
    public String getEditorial() {
        return Editorial;
    }

    /**
     * @param Editorial the Editorial to set
     */
    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    /**
     * @return the Anio
     */
    public int getAnio() {
        return Anio;
    }

    /**
     * @param Anio the Anio to set
     */
    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    /**
     * @return the Edición
     */
    public String getEdición() {
        return Edición;
    }

    /**
     * @param Edición the Edición to set
     */
    public void setEdición(String Edición) {
        this.Edición = Edición;
    }

    /**
     * @return the Categoría
     */
    public String getCategoría() {
        return Categoría;
    }

    /**
     * @param Categoría the Categoría to set
     */
    public void setCategoría(String Categoría) {
        this.Categoría = Categoría;
    }

    /**
     * @return the Idioma
     */
    public String getIdioma() {
        return Idioma;
    }

    /**
     * @param Idioma the Idioma to set
     */
    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
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

    /**
     * @return the ISBM
     */
    public int getISBM() {
        return ISBM;
    }

    /**
     * @param ISBM the ISBM to set
     */
    public void setISBM(int ISBM) {
        this.ISBM = ISBM;
    }
    
    
}
