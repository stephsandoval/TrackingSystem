package GUI;

import javax.swing.JFrame;

public class MenuScreen extends MainScreen {
    
    private JFrame frame;
    private FTSButton addScreenButton, updateScreenButton, historyScreenButton;

    public MenuScreen (){
        super();
        frame = this.getFrame();
        addLabel("FLOWER TRACKING SYSTEM");
        setButtons();
        frame.setVisible(true);
    }

    private void setButtons (){
        addScreenButton = new FTSButton("ADD", 40, 400, 100, 30, e -> changeScreen(Screen.PEOPLE));
        frame.getContentPane().add(addScreenButton);

        updateScreenButton = new FTSButton("UPDATE", 340, 400, 100, 30, e -> changeScreen(Screen.UPDATE));
        frame.getContentPane().add(updateScreenButton);

        historyScreenButton = new FTSButton("HISTORY", 640, 400, 100, 30, e -> changeScreen(Screen.HISTORY));
        frame.getContentPane().add(historyScreenButton);
        
    }

    @Override
    protected void callController (){}

    public static void main (String args[]){
        new MenuScreen();
    }
}
