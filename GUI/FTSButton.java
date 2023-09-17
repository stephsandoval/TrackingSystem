package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FTSButton extends JButton{

    enum Location {
        RIGHT, LEFT;
    }
    
    public FTSButton (String label, int x, int y, int width, int height, ActionListener action){
        super();
        this.setText(label);
        this.setBounds(x, y, width, height);
        this.addActionListener(action);
    }

    public FTSButton (String label, Location location, ActionListener action){
        super();
        this.setText(label);
        switch (location){
            case RIGHT:
                // fast way of setting a "large" button in the right bottom corner
                this.setBounds(640, 400, 100, 30);
                break;
            case LEFT:
                // fast way of setting a "small" button in the left bottom corner
                this.setBounds(40, 400, 60, 30);
                break;
            default:
                break;
        }
        this.addActionListener(action);
    }
}
