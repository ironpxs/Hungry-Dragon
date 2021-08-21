/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.BicondicionalControlador;
import controlador.DisyuncionControlador;
import controlador.ImplicacionControlador;
import controlador.InicioControlador;
import controlador.NegacionControlador;
import controlador.NombreRankingControlador;
import controlador.TutorialControlador;
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

import javafx.stage.Stage;
import java.applet.AudioClip;
import javafx.stage.StageStyle;


/**
 *
 * @author Administrador
 */
public class CountdownTask extends TimerTask{
    private int seg, segAux,intento,obs;
    private Label lblTiempo,lblPuntos,lblIntento;
    private ToggleButton btnOpCorrect;
    private ToggleGroup opciones;
    AudioClip winner = winner();
    
    Jugador j = Jugador.getInstancia();

    public CountdownTask(int seg, int intento, Label lblTiempo, Label lblPuntos, 
            Label lblIntento, ToggleButton btnOpCorrect, ToggleGroup opciones) {
        

        this.seg = seg;
        this.segAux = seg;
        this.intento = intento;
        this.lblTiempo = lblTiempo;
        this.lblPuntos = lblPuntos;
        this.lblIntento = lblIntento;
        this.btnOpCorrect = btnOpCorrect;
        this.opciones = opciones;
    }
    
   

    @Override
    public void run() {
        Platform.runLater(()->{
                    seg--;
                    System.out.println(seg);
                    lblTiempo.setText(String.valueOf(seg));
                    try{
                        if(seg>0){
                                j.setDuracion(j.getDuracion()+1);
                                if(obs==0){
                                    if(opciones.getSelectedToggle().equals(btnOpCorrect)){
                                            winner.play();
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
                                            if(btnOpCorrect.getId().compareToIgnoreCase("btnBicondicional")!=0){
                                                siguienteNivel();
                                                cancel();
                                                //ThreadsNiveles.t.cancel();
                                                
                                            }else{
                                                System.out.println("Ganó el juego");
                                                nombreRanking();
                                                cancel();
                                            }
                                            
                                    }
                            }
                               
                        }else{
                            if(intento>0){
                                if(intento > 1){
                                    seg = segAux;
                                }
                                intento--;
                                lblIntento.setText(String.valueOf(intento));
                            }
                            else if(intento == 0){
                                System.out.println("Perdió");
                                nombreRanking();
                                cancel(); 
                            }
                        }
                    }catch(NullPointerException e){
                        

                    }
                    
                    });
    }

    private void siguienteNivel(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaTutorial.fxml"));
                          
            Parent root = loader.load();
            
            TutorialControlador controlador = (TutorialControlador) loader.getController();
            
            Scene scene = new Scene(root,1012, 709);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
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
            stage.initStyle(StageStyle.UNDECORATED);
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
    


          
       
}


           