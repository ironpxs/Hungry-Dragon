/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.DisyuncionControlador;
import controlador.ImplicacionControlador;
import controlador.InicioControlador;
import controlador.Main;
import controlador.NegacionControlador;
import controlador.NombreRankingControlador;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.applet.AudioClip;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Toggle;

/**
 *
 * @author Administrador
 */
public class CountdownTask extends TimerTask{
    private ImageView imgDragon;
    private int seg, intento,obs;
    private Label lblTiempo,lblPuntos,lblIntento;
    private ToggleButton btnOpCorrect;
    private ToggleGroup opciones;
    AudioClip winner = winner();
    
    Jugador j = Jugador.getInstancia();

    public CountdownTask(ImageView imgDragon,int seg, int intento, Label lblTiempo, Label lblPuntos, 
            Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones) {
        
        this.imgDragon=imgDragon;
        this.seg = seg;
        this.intento = intento;
        this.lblTiempo = lblTiempo;
        this.lblPuntos = lblPuntos;
        this.lblIntento = lblIntento;
        this.btnOpCorrect = btnOpCorrect;
        this.opciones = opciones;
        this.obs=0;
    }
    
   

    @Override
    public void run() {
        Platform.runLater(()->{
                    seg--;
                    lblTiempo.setText(String.valueOf(seg));
                    try{
                        if(seg>0){
                                j.setDuracion(j.getDuracion()+1);
                                if(obs==0){
                                    if(opciones.getSelectedToggle().equals(btnOpCorrect)){
                                            momentoCorrecto();
                                            obs=seg;
                                            seg+=3;

                                            if(seg>30){
                                            //CORRECTO DEBE DEMORAR UN POCO.             


                                                if(intento>=2){
                                                    j.setPuntos(j.getPuntos()+20);
                                                }else{
                                                    j.setPuntos(j.getPuntos()+10);
                                                }

                                            }else if(seg<=30){
                                                //CORRECTO DEBE DEMORAR UN POCO.


                                                if(intento>=2){
                                                    j.setPuntos(j.getPuntos()+15);
                                                }else{
                                                    j.setPuntos(j.getPuntos()+5);
                                                }
                                            }
                                            lblPuntos.setText(String.valueOf(j.getPuntos()));   


                                            

                                }
                                else{

                                    imgDragon.setImage(new Image("/dragonImg/enojado.png"));
                                    intento--;
                                    lblIntento.setText(String.valueOf(intento));   
                                    if(intento == 0){
                                        System.out.println("Perdió");
                                        nombreRanking();
                                        cancel(); 
                                    }
                                   
                                }
                                opciones.getSelectedToggle().setSelected(false);
                            }else{
                                    if(seg==obs){
                                            if(btnOpCorrect.getId().compareToIgnoreCase("btnImplicacion")!=0){
                                                siguienteNivel();
                                                cancel();
                                            }else{
                                                System.out.println("Ganó el juego");
                                                nombreRanking();
                                                cancel();
                                            }
                                            
                                    }
                            }
                               
                        }
                    }catch(NullPointerException e){
                        

            }
                    
         });
    }

    private void siguienteNivel(){
        try {
            FXMLLoader loader=null;
            String idButton = btnOpCorrect.getId();
            if(idButton.compareToIgnoreCase("btnConjuncion")==0){
                loader = new FXMLLoader(getClass().getResource("/vista/VistaDisyuncion.fxml"));
            }else if(idButton.compareToIgnoreCase("btnDisyuncion")==0){
                loader = new FXMLLoader(getClass().getResource("/vista/VistaNegacion.fxml"));
            }else if(idButton.compareToIgnoreCase("btnNegacion")==0){
                loader = new FXMLLoader(getClass().getResource("/vista/VistaImplicacion.fxml"));
            }
            
            
            Parent root = loader.load();
            
            if(idButton.compareToIgnoreCase("btnConjuncion")==0){
                DisyuncionControlador controlador = (DisyuncionControlador) loader.getController();
            }else if(idButton.compareToIgnoreCase("btnDisyuncion")==0){
                NegacionControlador controlador = (NegacionControlador) loader.getController();
            }else if(idButton.compareToIgnoreCase("btnNegacion")==0){
                ImplicacionControlador controlador = (ImplicacionControlador) loader.getController();
            }
            
           
            Scene scene = new Scene(root,1012, 709);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnOpCorrect.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(InicioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nombreRanking(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NombreRankingVista.fxml"));
            Parent root = loader.load();
            NombreRankingControlador controlador = (NombreRankingControlador) loader.getController();
            Scene scene = new Scene(root,323,140);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            Stage myStage = (Stage) this.btnOpCorrect.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(CountdownTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public AudioClip winner(){
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/sonido/Winner.wav")); 
        return Sound;
    }
    

    private void momentoCorrecto(){
        imgDragon.setImage(new Image("/dragonImg/feliz.png"));    
        winner.play();
     
    } 
}


           