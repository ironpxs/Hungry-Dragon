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
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class TutorialControlador implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static int nivelAcumulador = 0; //El cero sería el primer nivel - conjunción
    private MediaPlayer mediaPlayer;
    private Media media;

    @FXML
    private Label lblTitulo;
    @FXML
    private ImageView imgViewCerrar;
    @FXML
    private MediaView videoView;
    @FXML
    private Button btnOmitir;
    @FXML
    private ImageView imgViewPlayPause;
    
    private String rutaPlayPause;
    private Image imgPlayPause;
    private URL linkPlayPause;
    
    public TutorialControlador(){
        rutaPlayPause = "/Img/play.png";
 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        switch(nivelAcumulador){
            case 0: Main.ruta = "/conjuncion/conjuncion.mp4";
                    lblTitulo.setText("TUTORIAL-CONJUNCION");
                    break;
            case 1: Main.ruta = "/disyuncion/disyuncion.mp4";
                    lblTitulo.setText("TUTORIAL-DISYUNCION");
                    break;
            case 2: Main.ruta = "/negacion/negacion.mp4";
                    lblTitulo.setText("TUTORIAL-NEGACION");
                    break;
            case 3: Main.ruta = "/implicacion/implicacion.mp4";
                    lblTitulo.setText("TUTORIAL-IMPLICACION");
                    break;
            case 4: Main.ruta = "/bicondicional/bicondicional.mp4";
                    lblTitulo.setText("TUTORIAL-BICONDICIONAL");
                    break;
        }
        
        URL linkTutorial=getClass().getResource(Main.ruta);
        media = new Media(linkTutorial.toString());
        mediaPlayer = new MediaPlayer(media);
        videoView.setMediaPlayer(mediaPlayer);
 
    }

    @FXML
    private void cerrar(MouseEvent event) {
        Stage myStage = (Stage) this.videoView.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void playPausa(MouseEvent event) {
        if(mediaPlayer.getStatus()==PLAYING){
            mediaPlayer.pause();
            rutaPlayPause = "/Img/play.png";
        }else{
            mediaPlayer.play();
            rutaPlayPause = "/Img/pause.png";
        }
        linkPlayPause =getClass().getResource(rutaPlayPause);
        imgPlayPause = new Image(linkPlayPause.toString(),62,65,false,true);
        imgViewPlayPause.setImage(imgPlayPause);
    }

    @FXML
    private void omitirTutorial(ActionEvent event) {
        mediaPlayer.stop();
        siguienteNivel();
    }
    
    private void siguienteNivel(){
        try {
            FXMLLoader loader=null;
            switch(nivelAcumulador){
                case 0: loader = new FXMLLoader(getClass().getResource("/vista/VistaConjuncion.fxml"));         
                        break;
                case 1: loader = new FXMLLoader(getClass().getResource("/vista/VistaDisyuncion.fxml"));
                        break;
                case 2: loader = new FXMLLoader(getClass().getResource("/vista/VistaNegacion.fxml"));
                        break;
                case 3: loader = new FXMLLoader(getClass().getResource("/vista/VistaImplicacion.fxml"));
                        break;
                case 4: loader = new FXMLLoader(getClass().getResource("/vista/VistaBicondicional.fxml"));
                        break;
               
            }
                       
            Parent root = loader.load();
            
            if(nivelAcumulador == 0){
                ConjuncionControlador controlador = (ConjuncionControlador) loader.getController();
            }
            else if(nivelAcumulador == 1){
                DisyuncionControlador controlador = (DisyuncionControlador) loader.getController();
            }
            else if(nivelAcumulador == 2){
                NegacionControlador controlador = (NegacionControlador) loader.getController();
            }else if(nivelAcumulador == 3){
                ImplicacionControlador controlador = (ImplicacionControlador) loader.getController();
            }else if(nivelAcumulador == 4){
                BicondicionalControlador controlador = (BicondicionalControlador) loader.getController();
            }
            
           
            Scene scene = new Scene(root,1012, 709);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            
            TutorialControlador.nivelAcumulador++;
            
            Stage myStage = (Stage) this.btnOmitir.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(InicioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    
    
    
}
