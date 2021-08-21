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
public class ThreadImplicacion extends ThreadsNiveles {
    
    public ThreadImplicacion(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones,Label lblEnunciado) {
        super(imgDragon,seg, intento, lblTiempo, lblPuntos, lblIntento, btnOpCorrect, opciones);
        super.setRutas(new RutasImagenesNiveles());
        //Enunciado
        lblEnunciado.setText("Elige la incorrecta:");
        super.getRutas().setOperador("/implicacion/implicacion.png");
        super.getRutas().setComidaIzquierda("/implicacion/Comida.png");    
        super.getRutas().setComidaDerecha("/implicacion/Bebida.png");
        //Dragon
        super.getRutas().setDragon("/dragonImg/enojado.png");
        //Opciones
        super.getRutas().setOpcion1("/implicacion/hamburguesayPollo.png");
        super.getRutas().setOpcion2("/implicacion/sodayHelado.png");
        super.getRutas().setOpcion3("/implicacion/hamburguesayAgua.png");
        super.getRutas().setOpcion4("/implicacion/sodayAgua.png");
    }
    
}
