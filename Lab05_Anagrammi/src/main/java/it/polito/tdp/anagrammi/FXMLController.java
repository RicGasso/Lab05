package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AnagrammiModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	
    	String parola = txtParola.getText();
    	if(parola.length()<2) {
    		txtCorretti.appendText("la parola inserita è troppo corta");
    	}else if(parola.length()>8) {
    		txtCorretti.appendText("la parola inserita è troppo lunga");
    	}
    	
    	Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    	for(String a: anagrammi) {
    		if(this.model.isCorrect(a)) {
    			txtCorretti.appendText(a + "\n");
    		}else {
    			txtErrati.appendText(a+"\n");
    		}
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtParola.clear();

    }
    
    public void setModel(AnagrammiModel model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
