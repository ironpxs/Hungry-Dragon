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
public class ThreadDisyuncion extends ThreadsNiveles{
    
    public ThreadDisyuncion(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, 
            Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones,Label lblEnunciado) {
        super(imgDragon,seg, intento, lblTiempo, lblPuntos, lblIntento, btnOpCorrect, opciones);
        super.setRutas(new RutasImagenesNiveles());
        //Enunciado
        lblEnunciado.setText("Elige la incorrecta:");
        
        super.getRutas().setOperador("/disyuncion/disyuncion.png");
        super.getRutas().setComidaIzquierda("/disyuncion/hamburguesa.png");
        super.getRutas().setComidaDerecha("/disyuncion/dona.png");
        //Dragon
        super.getRutas().setDragon("/dragonImg/espera.png");
        //Opciones
        super.getRutas().setOpcion1("/disyuncion/helado.png");
        super.getRutas().setOpcion2("/disyuncion/hamburguesayDona.png");
        super.getRutas().setOpcion3("/disyuncion/hamburguesa.png");
        super.getRutas().setOpcion4("/disyuncion/dona.png");
    }
    
    

   
}
