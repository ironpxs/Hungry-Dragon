/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrador
 */
public class ThreadNegacion extends ThreadsNiveles{
    
    public ThreadNegacion(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones,Label lblEnunciado) {
        super(imgDragon,seg, intento, lblTiempo, lblPuntos, lblIntento, btnOpCorrect, opciones);
        super.setRutas(new RutasImagenesNiveles());
        
        //Enunciado
        lblEnunciado.setText("");
        super.getRutas().setOperador("/negacion/negacion.png");
        super.getRutas().setComidaIzquierda("/negacion/papas.png");
        super.getRutas().setComidaDerecha("/negacion/papas.png");
        //Dragon
        super.getRutas().setDragon("/dragonImg/feliz.png");
        //Opciones
        super.getRutas().setOpcion1("/negacion/sodayPapas.png");
        super.getRutas().setOpcion2("/negacion/canguilyPapas.png");
        super.getRutas().setOpcion3("/negacion/papas.png");
        super.getRutas().setOpcion4("/negacion/pollo.png");
    }
    
}
