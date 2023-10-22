package Screens;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controllers.AddController;
import Flowers.PreFlower;
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
    private int x = 20, y = 102;

    private ArrayList <ArrayList <PreFlower>> userSelection = new ArrayList<>();

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        screenSpecies.getItems().setAll(items.getSpecies());
        screenSpecies.setOnAction(this::initializeType);
        screenType.setOnAction(this::initializeStemLength);
        screenStemLength.setOnAction(this::initializeAmount);
        screenAmount.setOnAction(this::initializeButtons);
    }

    private void initializeType (ActionEvent event){
        clearFlowers();
        String species = screenSpecies.getValue();
        typeLabel.setDisable(false);
        screenType.setDisable(false);
        screenType.getItems().setAll(items.getType(species));
    }

    private void initializeStemLength (ActionEvent event){
        clearFlowers();
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
            userSelection.add(new ArrayList<>());
            firstFlower = false;
        }
        String orderSpecies = screenSpecies.getValue();
        String type = screenType.getValue();
        String stemLength = screenStemLength.getText();
        String amount = screenAmount.getText();

        userSelection.get(currentBouquet).add(new PreFlower(orderSpecies, type, Float.valueOf(stemLength), Integer.valueOf(amount)));
        showOrder(orderSpecies, type, stemLength, amount);
        clearFlowers();
        screenStemLength.setDisable(true);
        screenAmount.setDisable(true);
    }

    public void addBouquet (){
        if (!firstFlower){
            currentBouquet++;
            firstFlower = true;
            showOrder("-------------------------");
        }
    }

    public void finishOrder (ActionEvent event){
        // before finishing order, check the client input
        clientName = screenName.getText();
        arrivalDate = screenDate.getValue(); 
        arrivalPlace = screenPlace.getText();
        clearScreen();
        new AddController(this);
    }

    private void showOrder (String species, String type, String stemLength, String amount){
        Label newLabel = new Label(species + " > " + type + " > " + stemLength + " > " + amount);
        newLabel.setLayoutX(x);
        newLabel.setLayoutY(y);
        y += 30;
        orderPane.getChildren().add(newLabel);
    }

    private void showOrder (String divider){
        Label newLabel = new Label(divider);
        newLabel.setLayoutX(x);
        newLabel.setLayoutY(y);
        y += 30;
        orderPane.getChildren().add(newLabel);
    }

    public String getClientName (){
        return this.clientName;
    }

    public String getArrivalPlace (){
        return this.arrivalPlace;
    }

    public LocalDate getArrivalDate (){
        return this.arrivalDate;
    }

    public ArrayList <ArrayList <PreFlower>> getUserSelection (){
        return this.userSelection;
    }

    private void clearScreen (){
        screenName.clear();
        screenPlace.clear();
    }

    private void clearFlowers (){
        screenAmount.clear();
        screenStemLength.clear();
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