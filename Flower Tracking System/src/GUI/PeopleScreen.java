package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PeopleScreen extends MainScreen{
    
    private JFrame frame;
    private JButton submitButton;
    private FTSTextField company, date, employeeName, employeeID, clientName;

    public PeopleScreen (){
        super();
        frame = this.getFrame();
        frame.setLayout(new FlowLayout());
        addLabel("ADD NEW ORDER");
        setTextFields();
        setButton();
        addReturnButton();
        frame.setVisible(true);
    }

    private void setTextFields (){
        company = new FTSTextField("Company name", 40, 100, 700, 30);
        frame.getContentPane().add(company);
        date = new FTSTextField("Date", 40, 150, 700, 30);
        frame.getContentPane().add(date);
        employeeName = new FTSTextField("Employee Name", 40, 200, 700, 30);
        frame.getContentPane().add(employeeName);
        employeeID = new FTSTextField("Employee ID", 40, 250, 700, 30);
        frame.getContentPane().add(employeeID);
        clientName = new FTSTextField("Client Name", 40, 300, 700, 30);
        frame.getContentPane().add(clientName);
    }

    private void setButton (){
        submitButton = new FTSButton("CONTINUE", FTSButton.Location.RIGHT, e -> changeScreen(Screen.ADD));
        frame.getContentPane().add(submitButton);
    }

    @Override
    protected void callController (){}
}