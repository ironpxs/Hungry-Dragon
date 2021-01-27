/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Timer;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrador
 */
public class ThreadConjuncion extends ThreadsNiveles {

    public ThreadConjuncion(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones) {
        super(imgDragon,seg, intento, lblTiempo, lblPuntos, lblIntento, btnOpCorrect, opciones);
        super.setRutas(new RutasImagenesNiveles());
        //Enunciado
        super.getRutas().setOperador("/conjuncion/conjuncion.png");
        super.getRutas().setComidaIzquierda("/conjuncion/bebida.png");
        super.getRutas().setComidaDerecha("/conjuncion/canguil.png");
        //Dragon
        super.getRutas().setDragon("/dragonImg/espera.png");
        //Opciones
        super.getRutas().setOpcion1("/conjuncion/bebida.png");
        super.getRutas().setOpcion2("/conjuncion/sodayCanguil.png");
        super.getRutas().setOpcion3("/conjuncion/canguil.png");
        super.getRutas().setOpcion4("/conjuncion/hamburguesa.png");
    }
     
     
}
