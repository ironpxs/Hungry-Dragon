/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import controlador.ConjuncionControlador;
import java.applet.AudioClip;
/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class InicioControlador implements Initializable {

    @FXML
    private Button btnJugar;
    private AudioClip intro = intro();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {       

        intro.loop();
    }    

    @FXML
    private void jugar(ActionEvent event) {
        intro.stop();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaConjuncion.fxml"));
            
            Parent root = loader.load();

            ConjuncionControlador controlador = (ConjuncionControlador) loader.getController();
           
            Scene scene = new Scene(root,1012, 709);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnJugar.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(InicioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
    public AudioClip intro(){
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/sonido/intro.wav")); 
        return Sound;
    }
}
