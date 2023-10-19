package GUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class MainScreen {
    
    private JFrame frame;
    private ImageIcon logo;
    private JLabel label;
    private FTSButton returnButton;

    enum Screen {
        MENU, PEOPLE, ADD, UPDATE, HISTORY;
    }

    public MainScreen (){
        frame = new JFrame("Flower Tracking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 500);

        logo = new ImageIcon("flowerLogo.png");
        frame.setIconImage(logo.getImage());
    }

    protected void addLabel (String title){
        label = new JLabel(title);
        label.setFont(new Font("Impact", Font.PLAIN, 40));
        label.setBounds(0, 30, 780, 40);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(label);
    }

    protected JFrame getFrame () {
        return this.frame;
    }

    protected void returnMenu (JFrame frame){
        frame.dispose();
        new MenuScreen();
    }

    protected void changeScreen (Screen screen){
        frame.dispose();
        switch (screen){
            case MENU:
                new MenuScreen();
                break;
            case PEOPLE:
                new PeopleScreen();
                break;
            case ADD:
                new AddScreen();
                break;
            case UPDATE:
                new UpdateScreen();
                break;
            case HISTORY:
                new HistoryScreen();
            default:
                break;
        }
    }

    protected void addReturnButton (){
        returnButton = new FTSButton("<", FTSButton.Location.LEFT, e -> returnMenu(frame));
        returnButton.setBounds(40, 400, 60, 30);
        frame.getContentPane().add(returnButton);
    }

    abstract protected void callController ();
}