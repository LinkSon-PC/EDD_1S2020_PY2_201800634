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
    private long ISBN;
    private String Título;
    private String Autor;
    private String Editorial;
    private int Anio;
    private String Edición;
    private String Categoría;
    private String Idioma;
    private long Carnet;

    public Llave() {
    }

    public Llave(long ISBN, String Título, String Autor, String Editorial, int Anio, String Edición, String Categoría, String Idioma, long Carnet) {
        this.ISBN = ISBN;
        this.Título = Título;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.Anio = Anio;
        this.Edición = Edición;
        this.Categoría = Categoría;
        this.Idioma = Idioma;
        this.Carnet = Carnet;
    }

    
    
    public boolean MenorQue(long _Valor){
        return getISBN()<_Valor;
    }
    public boolean MayorQue(long _Valor){
        return getISBN()>_Valor;
    }
    public boolean IgualQue(long _Valor){
        return getISBN()==_Valor;
    }
    
    public String toString(){
        return this.ISBN + "\n" + this.Título +"\n"+ this.Categoría;
//        return this.ISBN +" \n"+ this.Título + " \n"+ this.Autor +" \n"+ this.Editorial +" \n"
//                + this.Anio +" \n"+ this.Edición +" \n"+ this.Categoría +"\n"+ this.Idioma +" \n"+ this.Carnet;
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
    public long getCarnet() {
        return Carnet;
    }

    /**
     * @param Carnet the Carnet to set
     */
    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }

    /**
     * @return the ISBN
     */
    public long getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    
}
