package GUI;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class UpdateScreen extends MainScreen {
    
    private JFrame frame;
    private FTSTextField productID, date, company, location, description;
    private FTSButton searchButton, submitButton;
    private FTSComboBox status;

    public UpdateScreen (){
        super();
        frame = this.getFrame();
        frame.setLayout(new FlowLayout());
        addLabel("UPDATE PRODUCT");
        setSearch();
        setStatusBox();
        addSearchButton();
        showSubmitButton();
        addReturnButton();
        frame.setVisible(true);
    }

    private void setSearch (){
        productID = new FTSTextField("Product ID", 40, 100, 600, 30);
        frame.getContentPane().add(productID);
    }

    private void addSearchButton (){
        searchButton = new FTSButton("GO", 680, 100, 60, 30, e -> setTextFields());
        frame.getContentPane().add(searchButton);
    }

    private void setStatusBox (){
        String[] statusOptions = {"in process", "shipping", "loading", "travelling", "damaged", "in location", "on hold"};
        status = new FTSComboBox(statusOptions, 40, 300, 350, 30, null);
        status.setVisible(false);
        frame.getContentPane().add(status);
    }

    private void setTextFields (){
        submitButton.setEnabled(true);
        status.setVisible(true);

        date = new FTSTextField("Date", 40, 150, 350, 30);
        frame.getContentPane().add(date);

        company = new FTSTextField("Company", 40, 200, 350, 30);
        frame.getContentPane().add(company);

        location = new FTSTextField("Location", 40, 250, 350, 30);
        frame.getContentPane().add(location);

        description = new FTSTextField("Description", 430, 150, 310, 180);
        frame.getContentPane().add(description);
    }

    private void showSubmitButton (){
        submitButton = new FTSButton("SUBMIT", FTSButton.Location.RIGHT, e -> doSomething());
        submitButton.setEnabled(false);
        frame.getContentPane().add(submitButton);
    }

    private void doSomething (){
        System.out.println("The submit button has been pressed");
        // do something to send the changes to the controller
    }

    @Override
    protected void callController (){}
}