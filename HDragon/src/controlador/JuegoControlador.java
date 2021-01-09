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
import javafx.scene.image.ImageView;



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
        
    }
       
    
}
