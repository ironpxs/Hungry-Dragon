/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import modelo.RutasImagenesNiveles;
import modelo.ThreadConjuncion;



/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class ConjuncionControlador implements Initializable {

    @FXML
    private ToggleButton btnOp1;
    @FXML
    private ImageView imgDragon;
    @FXML
    private ImageView imgComida1;
    @FXML
    private ImageView imgComida2;
    @FXML
    private ImageView imgOperador;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblIntento;

    @FXML
    private ToggleButton btnOp3;
    @FXML
    private ToggleButton btnOp4;
    
    @FXML
    private Label lblEnunciado;
    
    @FXML
    private Label lblPuntos;
    @FXML
    private ToggleGroup opciones=null;
    
    private int intento;
    private int seg;
    private ToggleButton btnOpCorrect;
    @FXML
    private ToggleButton btnConjuncion;
   
    public ConjuncionControlador() {
        this.seg = 60;
        this.intento = 2;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTiempo.setText(String.valueOf(seg));
        lblIntento.setText(String.valueOf(intento));
        
        //Conjuncion
        btnOpCorrect = btnConjuncion;
        ThreadConjuncion nivelConjuncion = new ThreadConjuncion(imgDragon,seg,intento,lblTiempo,lblPuntos,lblIntento,btnOpCorrect,opciones);
        Runnable r1 = nivelConjuncion;
        Thread hiloConjuncion = new Thread(r1);
        colocarImagenes(nivelConjuncion.getRutas());
        hiloConjuncion.start();
        
       
   }
   
    private void colocarImagenes(RutasImagenesNiveles rutas){
       //Enunciado
       URL linkOperador=getClass().getResource(rutas.getOperador());
       URL linkComidaIzquierda=getClass().getResource(rutas.getComidaIzquierda());
       URL linkComidaDerecha=getClass().getResource(rutas.getComidaDerecha());
       
       Image imagenOperador = new Image(linkOperador.toString(),47,38,false,true);
       Image imagenComidaIzquierda = new Image(linkComidaIzquierda.toString(),129,114,false,true);
       Image imagenComidaDerecha = new Image(linkComidaDerecha.toString(),129,114,false,true);
       
       imgOperador.setImage(imagenOperador);
       imgComida1.setImage(imagenComidaIzquierda);
       imgComida2.setImage(imagenComidaDerecha);
       //Dragon
       URL linkDragon=getClass().getResource(rutas.getDragon());
       
       Image imagenDragon = new Image(linkDragon.toString(),311,371,true,true);
       imgDragon.setImage(imagenDragon);
       //Opciones
       URL linkOp1=getClass().getResource(rutas.getOpcion1());
       URL linkOp2=getClass().getResource(rutas.getOpcion2());
       URL linkOp3=getClass().getResource(rutas.getOpcion3());
       URL linkOp4=getClass().getResource(rutas.getOpcion4());
       
       Image imagenOp1 = new Image(linkOp1.toString(),200,149,true,true);
       Image imagenOp2 = new Image(linkOp2.toString(),200,149,true,true);
       Image imagenOp3 = new Image(linkOp3.toString(),200,149,true,true);
       Image imagenOp4 = new Image(linkOp4.toString(),200,149,true,true);
       
       btnOp1.setGraphic((new ImageView(imagenOp1)));
       btnConjuncion.setGraphic((new ImageView(imagenOp2)));
       btnOp3.setGraphic((new ImageView(imagenOp3)));
       btnOp4.setGraphic((new ImageView(imagenOp4)));
        
   }
}
