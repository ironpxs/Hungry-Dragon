/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Jugador implements Comparable<Jugador>, Serializable{
    
    private String nombre;
    private int puntos;
    private int duracion;
    
    private static Jugador instancia;
    
    private Jugador(){}
    
    public static Jugador getInstancia(){
        if(instancia == null){
            instancia = new Jugador();
            instancia.setPuntos(0);
            instancia.setDuracion(0);
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntos=" + puntos + ", duracion=" + duracion + '}';
    }

    @Override
    public int compareTo(Jugador t2) {
        if(this.getPuntos()<t2.getPuntos()){
            return 1;
        }else if(this.getPuntos()==t2.getPuntos()){
            if(this.getDuracion()>t2.getDuracion()){
                return 1;
            }else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }

   

    
    
}
