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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.RutasImagenesNiveles;
import modelo.ThreadBicondicional;


/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class BicondicionalControlador implements Initializable {

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
    private Label lblEnunciado;
    @FXML
    private Label lblPuntos;
    @FXML
    private ToggleButton btnOp4;
    @FXML
    private ToggleGroup opciones;
    @FXML
    private ToggleButton btnOp2;
    @FXML
    private ToggleButton btnBicondicional;
    @FXML
    private ToggleButton btnOp1;
    
    private int intento;
    private int seg;
    private ToggleButton btnOpCorrect;
    @FXML
    private ImageView imgViewCerrar;
    
    
    public BicondicionalControlador() {
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
        lblPuntos.setText(String.valueOf(Jugador.getInstancia().getPuntos()));  
        //Implicacion
        btnOpCorrect = btnBicondicional;
        imgComida1.setVisible(true);
        ThreadBicondicional nivelBicondicional = new ThreadBicondicional(imgDragon,seg,intento,lblTiempo,lblPuntos,lblIntento,btnOpCorrect,opciones, lblEnunciado);
        Runnable r3 = nivelBicondicional;
        Thread hiloImplicacion = new Thread(r3);
        colocarImagenes(nivelBicondicional.getRutas());
        hiloImplicacion.start();   
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
       btnOp2.setGraphic((new ImageView(imagenOp2)));
       btnBicondicional.setGraphic((new ImageView(imagenOp3)));
       btnOp4.setGraphic((new ImageView(imagenOp4)));
        
   }

    @FXML
    private void cerrar(MouseEvent event) {
        Stage myStage = (Stage) this.imgViewCerrar.getScene().getWindow();
        myStage.close();
    }
}
