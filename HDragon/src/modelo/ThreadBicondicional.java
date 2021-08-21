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
public class ThreadBicondicional extends ThreadsNiveles {
    
    public ThreadBicondicional(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones,Label lblEnunciado) {
        super(imgDragon,seg, intento, lblTiempo, lblPuntos, lblIntento, btnOpCorrect, opciones);
        super.setRutas(new RutasImagenesNiveles());
        //Enunciado
        lblEnunciado.setText("");
        super.getRutas().setOperador("/bicondicional/bicondicional.png");
        super.getRutas().setComidaIzquierda("/bicondicional/hamburguesa.png");    
        super.getRutas().setComidaDerecha("/bicondicional/soda.png");
        //Dragon
        super.getRutas().setDragon("/dragonImg/feliz.png");
        //Opciones
        super.getRutas().setOpcion1("/bicondicional/burgerHelado.png");
        super.getRutas().setOpcion2("/bicondicional/sodaAgua.png");
        super.getRutas().setOpcion3("/bicondicional/burgerSoda.png");
        super.getRutas().setOpcion4("/bicondicional/burgerDona.png");
    }
    
}
