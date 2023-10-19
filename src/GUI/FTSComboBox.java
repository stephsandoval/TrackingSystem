package GUI;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class FTSComboBox extends JComboBox<Object> {
    
    public FTSComboBox (String[] options, int x, int y, int width, int height, ActionListener action){
        super(options);
        this.setBounds(x, y, width, height);
        this.addActionListener(action);
    }

    protected void updateContents (String[] options){
        DefaultComboBoxModel<Object> defaultComboBoxModel;
        defaultComboBoxModel = new DefaultComboBoxModel<>(options);
        this.setModel(defaultComboBoxModel);
    }
}
