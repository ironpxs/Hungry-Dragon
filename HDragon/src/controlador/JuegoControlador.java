/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.RutasImagenesNiveles;



/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class JuegoControlador implements Initializable {

    @FXML
    private Button btnOp1;
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
    private Button btnOp2;
    @FXML
    private Button btnOp3;
    @FXML
    private Button btnOp4;
    
    private int intento;
    
    //Atributos de cuenta regresiva
    private Timer t;
    private TimerTask task;
    private int seg;
   
    public JuegoControlador() {
        this.seg = 10;
        this.intento = 2;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTiempo.setText(String.valueOf(seg));
        lblIntento.setText(String.valueOf(intento));
        t = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                        seg--;
                        System.out.println(seg);
                        lblTiempo.setText(String.valueOf(seg));
                        if(seg==0){
                            t.cancel();
                        }
                    
                });
            }
        };
        t.schedule(task, 1000,1000);
        RutasImagenesNiveles nivelConjuncion = new RutasImagenesNiveles();
        //Enunciado
        nivelConjuncion.setOperador("/conjuncion/conjuncion.png");
        nivelConjuncion.setComidaIzquierda("/conjuncion/bebida.png");
        nivelConjuncion.setComidaDerecha("/conjuncion/canguil.png");
        //Dragon
        nivelConjuncion.setDragon("/dragonImg/espera.png");
        //Opciones
        nivelConjuncion.setOpcion1("/conjuncion/bebida.png");
        nivelConjuncion.setOpcion2("/conjuncion/sodayCanguil.png");
        nivelConjuncion.setOpcion3("/conjuncion/canguil.png");
        nivelConjuncion.setOpcion4("/conjuncion/hamburguesa.png");
        colocarImagenes(nivelConjuncion);
        
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
       
       Image imagenDragon = new Image(linkDragon.toString(),394,366,false,true);
       
       imgDragon.setImage(imagenDragon);
       //Opciones
       URL linkOp1=getClass().getResource(rutas.getOpcion1());
       URL linkOp2=getClass().getResource(rutas.getOpcion2());
       URL linkOp3=getClass().getResource(rutas.getOpcion3());
       URL linkOp4=getClass().getResource(rutas.getOpcion4());
       
       Image imagenOp1 = new Image(linkOp1.toString(),129,114,false,true);
       Image imagenOp2 = new Image(linkOp2.toString(),129,114,false,true);
       Image imagenOp3 = new Image(linkOp3.toString(),129,114,false,true);
       Image imagenOp4 = new Image(linkOp4.toString(),129,114,false,true);
       
       btnOp1.setGraphic((new ImageView(imagenOp1)));
       btnOp2.setGraphic((new ImageView(imagenOp2)));
       btnOp3.setGraphic((new ImageView(imagenOp3)));
       btnOp4.setGraphic((new ImageView(imagenOp4)));
        
   }
    
}
