/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class RankingControlador implements Initializable {

    @FXML
    private Label lblGanador1;
    @FXML
    private Label lblGanador2;
    @FXML
    private Label lblGanador3;
    @FXML
    private TableView<Jugador> tblRanking;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colPuntos;
    @FXML
    private TableColumn colDuracion;
    private String filename = "src\\modelo\\archivo.dat";
    AudioClip aplauso = aplauso();
    AudioClip epicwin = epicwin();
    Jugador j = Jugador.getInstancia();
    
    private ObservableList<Jugador> jugadores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugadores = FXCollections.observableArrayList();
        importarDatos();
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPuntos.setCellValueFactory(new PropertyValueFactory("puntos"));
        this.colDuracion.setCellValueFactory(new PropertyValueFactory("duracion"));
        jugadores.add(j);
        tblRanking.setItems(jugadores);
        exportarDatos();
          
        Collections.sort(jugadores);
        lblGanador1.setText(jugadores.get(0).getNombre());
        if(jugadores.get(0).getNombre().compareToIgnoreCase(j.getNombre())==0){
            epicwin.loop();
        }else{
            aplauso.loop();
        }
        if(jugadores.size()>1){
            lblGanador2.setText(jugadores.get(1).getNombre());
            lblGanador3.setText(jugadores.get(2).getNombre());
        }
    }

    
    public void exportarDatos(){
       
            try {
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(filename));
                escribiendo_fichero.writeObject(new ArrayList<Jugador>(jugadores));
                escribiendo_fichero.close(); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RankingControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RankingControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
    public void importarDatos(){
        Path path = Paths.get(filename);
        if(Files.exists(path)){
            try {
                ObjectInputStream recuperando_fichero = null;
   
                recuperando_fichero = new ObjectInputStream(new FileInputStream(filename));
                ArrayList<Jugador> jugadores2 = (ArrayList<Jugador>) recuperando_fichero.readObject();
                for(Jugador c:jugadores2){
                    jugadores.add(c);
                    
                }
                tblRanking.setItems(jugadores);
                recuperando_fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(RankingControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RankingControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        }
       
    }
    
    public AudioClip aplauso(){
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/sonido/Aplauso.wav")); 
        return Sound;
    }

    private AudioClip epicwin() {
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/sonido/Epicwin.wav")); 
        return Sound;
    }
    
    
    
}

