package GUI;

import javax.swing.JTextField;

public class FTSTextField extends JTextField{

    public FTSTextField (String label, int x, int y, int width, int height){
        super(label);
        this.setBounds(x, y, width, height);
    }
    
}