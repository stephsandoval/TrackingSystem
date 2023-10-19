package GUI;

import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

public class AddScreen extends MainScreen{

    private JFrame frame;
    private FTSComboBox flowerCombo, speciesCombo, sizeCombo;
    private FTSTextField amount, orderPreview;
    private FTSButton submitButton, addButton;

    public AddScreen (){
        super();
        frame = this.getFrame();
        frame.setLayout(new FlowLayout());
        addLabel("ADD NEW ORDER");
        showOrderPreview();
        showComboBoxes();
        addButtons ();
        addReturnButton();
        frame.setVisible(true);
    }

    private void showComboBoxes (){
        String[] flowers = {"rose", "carnation", "orchid"};
        String[] empty = {"", ""};

        flowerCombo = new FTSComboBox(flowers, 40, 100, 350, 30, e -> showSecondCombo());
        frame.getContentPane().add(flowerCombo);
        
        speciesCombo = new FTSComboBox(empty, 40, 150, 350, 30, e -> showThirdCombo());
        frame.getContentPane().add(speciesCombo);

        sizeCombo = new FTSComboBox(empty, 40, 200, 350, 30, e -> setTextField());
        frame.getContentPane().add(sizeCombo);
    }

    private void showSecondCombo (){
        String[] roseSpecies = {"hybrid tea", "spray", "sweetheart"};
        String[] carnationSpecies = {"standard", "mini", "hybrid"};
        String[] orchidSpecies = {"moth", "dendrobium", "dancing lady"};
        String option;

        option = (String) flowerCombo.getSelectedItem();
        switch (option){
            case "rose":
                speciesCombo.updateContents(roseSpecies);
                break;
            case "carnation":
                speciesCombo.updateContents(carnationSpecies);
                break;
            case "orchid":
                speciesCombo.updateContents(orchidSpecies);
                break;
        }
    }

    private void showThirdCombo (){
        String[] sizes = {"small", "medium", "premium"};
        DefaultComboBoxModel<Object> defaultComboBoxModel;
        
        defaultComboBoxModel = new DefaultComboBoxModel<>(sizes);
        sizeCombo.setModel(defaultComboBoxModel);
    }
    
    private void setTextField (){
        submitButton.setEnabled(true);
        addButton.setEnabled(true);
        amount = new FTSTextField("Amount", 40, 250, 350, 30);
        frame.getContentPane().add(amount);
    }

    private void showOrderPreview (){
        orderPreview = new FTSTextField("Order Preview", 430, 100, 310, 250);
        frame.getContentPane().add(orderPreview);
    }

    private void addButtons (){
        submitButton = new FTSButton("SUBMIT", FTSButton.Location.RIGHT, e -> doSomething());
        submitButton.setEnabled(false);
        frame.getContentPane().add(submitButton);

        addButton = new FTSButton("ADD", 290, 320, 100, 30, e -> doSomething());
        addButton.setEnabled(false);
        frame.getContentPane().add(addButton);
    }

    private void doSomething (){
        System.out.println("One of the buttons has been pressed");
        // something must be done here in order to send the order to the controller
        // and then create another function to process the action of the ADD button
    }

    @Override
    protected void callController (){}
}