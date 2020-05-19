/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import ARBOLAVL.ArbolAVL;
import ARBOLB.ArbolB;
import ARBOLB.Llave;
import TABLA_HASH.THASH;
import TABLA_HASH.Usuario;

/**
 *
 * @author Home
 */
public class Sesion {
    public static ArbolAVL _ArbolAVL=new ArbolAVL();
    public static ArbolB _ArbolB=new ArbolB();
    public static THASH _TablaHash=new THASH();
    
    public static Usuario _User = new Usuario();
}
