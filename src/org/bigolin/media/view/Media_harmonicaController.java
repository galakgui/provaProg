package org.bigolin.media.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.bigolin.media.model.ItemMedia;
import org.bigolin.media.model.MediaHarmonicaCalculator;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class Media_harmonicaController implements Initializable {

    @FXML
    private TextField descricaoTextField;
    @FXML
    private TextField pesoTextField;
    @FXML
    private TextField notaTextField;
    @FXML
    private Button CalButton; 
    @FXML
    private Button SalButton;
    @FXML
    private Button AdiButton;
    @FXML
     Label resultadoLabel;
    
      @FXML
      TableView<ItemMedia> table;
      @FXML
      TableColumn<ItemMedia, String> descTC;
      @FXML
      TableColumn<ItemMedia, String> pesTC;
      @FXML
      TableColumn<ItemMedia, String> notTC;

    
    private MediaHarmonicaCalculator mc = new MediaHarmonicaCalculator();
    //Inicializa tudoooo
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        descTC.setCellValueFactory(val -> {
            return new ReadOnlyStringWrapper(val.getValue().getName());
        });
        
        pesTC.setCellValueFactory(val -> {
            return new ReadOnlyStringWrapper("" + val.getValue().getPeso());
        });
        
        notTC.setCellValueFactory(val -> {
            return new ReadOnlyStringWrapper("" + val.getValue().getNota());
        });
    }

    @FXML
    public void add() {
        
        String nome = descricaoTextField.getText();
        Double peso = Double.parseDouble(pesoTextField.getText());
        Double nota = Double.parseDouble(notaTextField.getText());
        
        ItemMedia item = new ItemMedia(nome, nota, peso);
        
        mc.addNota(item);
        table.getItems().add(item);
    }
    @FXML
    public void calcular() throws Exception  {
            resultadoLabel.setText("Resultado:  " +  mc.calcula());
    }
    @FXML
    public void inserirBD(){
         String nome = descricaoTextField.getText();
        Double peso = Double.parseDouble(pesoTextField.getText());
        Double nota = Double.parseDouble(notaTextField.getText());
        
        ItemMedia item = new ItemMedia(nome, nota, peso);
        
        item.insert();
    }
    }


    
    

