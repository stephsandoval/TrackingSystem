package Screens;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Json.JsonParser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddScreen extends ScreenChanger implements Initializable{
    
    @FXML
    private TextField screenName, screenPlace, screenStemLength, screenAmount;
    @FXML
    private DatePicker screenDate;
    @FXML
    private ChoiceBox <String> screenSpecies, screenType;
    @FXML
    private Label typeLabel, stemLengthLabel, amountLabel;
    @FXML
    private Button addFlowerButton, newBouquetButton, finishOrderButton;
    @FXML
    private Pane orderPane;

    private String clientName, arrivalPlace;
    private LocalDate arrivalDate;

    private JsonParser items = JsonParser.getInstance();
    private int currentBouquet = 0;
    private boolean firstFlower = true;

    private ArrayList <ArrayList <String>> species = new ArrayList<>();
    private ArrayList <ArrayList <String>> types = new ArrayList<>();
    private ArrayList <ArrayList <Integer>> amounts = new ArrayList<>();
    private ArrayList <ArrayList <Float>> stemLengths = new ArrayList<>();

    public void finishOrder (ActionEvent event){
        clientName = screenName.getText();
        arrivalDate = screenDate.getValue(); 
        arrivalPlace = screenPlace.getText();
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        screenSpecies.getItems().setAll(items.getSpecies());
        screenSpecies.setOnAction(this::initializeType);
        screenType.setOnAction(this::initializeStemLength);
        screenStemLength.setOnAction(this::initializeAmount);
        screenAmount.setOnAction(this::initializeButtons);
    }

    public void initializeType (ActionEvent event){
        String species = screenSpecies.getValue();
        typeLabel.setDisable(false);
        screenType.setDisable(false);
        screenType.getItems().setAll(items.getType(species));
        System.out.println(species);
    }

    private void initializeStemLength (ActionEvent event){
        stemLengthLabel.setDisable(false);
        screenStemLength.setDisable(false);
    }

    private void initializeAmount (ActionEvent event){
        float stemLength = Float.valueOf(screenStemLength.getText());
        if (validateStemLength(stemLength)){
            amountLabel.setDisable(false);
            screenAmount.setDisable(false);
        }
    }

    private void initializeButtons (ActionEvent event){
        int amount = Integer.valueOf(screenAmount.getText());
        if (validateAmount(amount)){
            addFlowerButton.setDisable(false);
            finishOrderButton.setDisable(false);
            newBouquetButton.setDisable(false);
        }
    }

    private boolean validateStemLength (float stemLength){
        return stemLength <= 40 && stemLength >= 8;
    }

    private boolean validateAmount (int amount){
        return amount > 0;
    }

    public void addToOrder (){
        if (firstFlower){
            species.add(new ArrayList<>());
            types.add(new ArrayList<>());
            stemLengths.add(new ArrayList<>());
            amounts.add(new ArrayList<>());
            firstFlower = false;
        }
        species.get(currentBouquet).add(screenSpecies.getValue());
        types.get(currentBouquet).add(screenType.getValue());
        stemLengths.get(currentBouquet).add(Float.valueOf(screenStemLength.getText()));
        amounts.get(currentBouquet).add(Integer.valueOf(screenAmount.getText()));
        System.out.println(species + "\n\n" + types + "\n\n" + stemLengths + "\n\n" + amounts);
    }

    /* 
    private boolean validDate (){
        LocalDate today = LocalDate.now();
        if (today.isAfter(arrivalDate)){
            return false; // not valid
        }
        return true;
    }
        
    */
}