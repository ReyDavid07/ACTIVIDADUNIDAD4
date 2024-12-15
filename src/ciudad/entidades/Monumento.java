/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudad.entidades;

import java.io.Serializable;


public class Monumento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int anoConstruccion;
    private String importanciaHistorica;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoConstruccion() {
        return anoConstruccion;
    }

    public void setAnoConstruccion(int anoConstruccion) {
        this.anoConstruccion = anoConstruccion;
    }

    public String getImportanciaHistorica() {
        return importanciaHistorica;
    }

    public void setImportanciaHistorica(String importanciaHistorica) {
        this.importanciaHistorica = importanciaHistorica;
    }

    
   
}
