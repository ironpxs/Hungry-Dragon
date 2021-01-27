/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.URL;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrador
 */
public abstract class ThreadsNiveles implements Runnable{
    private RutasImagenesNiveles rutas;
    private CountdownTask task;
    private int seg, intento;
    private ImageView imgDragon;
    private Label lblTiempo,lblPuntos,lblIntento;
    private ToggleButton btnOpCorrect;
    private ToggleGroup opciones;
    private Timer t;

    public ThreadsNiveles(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, Label lblIntento, 
            ToggleButton btnOpCorrect, ToggleGroup opciones) {
        this.imgDragon=imgDragon;
        this.seg = seg;
        this.intento = intento;
        this.lblTiempo = lblTiempo;
        this.lblPuntos = lblPuntos;
        this.lblIntento = lblIntento;
        this.btnOpCorrect = btnOpCorrect;
        this.opciones = opciones;
        this.t = new Timer();
    }
    
    @Override
    public void run() {
        task = new CountdownTask(imgDragon,seg,intento,lblTiempo,lblPuntos,lblIntento,btnOpCorrect,opciones);
        t.schedule(task, 1000,1000);
        t.purge();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadsNiveles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }


    public Label getLblTiempo() {
        return lblTiempo;
    }

    public void setLblTiempo(Label lblTiempo) {
        this.lblTiempo = lblTiempo;
    }

    public Label getLblPuntos() {
        return lblPuntos;
    }

    public void setLblPuntos(Label lblPuntos) {
        this.lblPuntos = lblPuntos;
    }

    public Label getLblIntento() {
        return lblIntento;
    }

    public void setLblIntento(Label lblIntento) {
        this.lblIntento = lblIntento;
    }

    public ToggleButton getBtnOpCorrect() {
        return btnOpCorrect;
    }

    public void setBtnOpCorrect(ToggleButton btnOpCorrect) {
        this.btnOpCorrect = btnOpCorrect;
    }

    public ToggleGroup getOpciones() {
        return opciones;
    }

    public void setOpciones(ToggleGroup opciones) {
        this.opciones = opciones;
    }
    
     public RutasImagenesNiveles getRutas() {
        return rutas;
    }

    public void setRutas(RutasImagenesNiveles rutas) {
        this.rutas = rutas;
    }
    
}
