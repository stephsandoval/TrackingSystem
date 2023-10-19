package GUI;

import javax.swing.JFrame;

public class HistoryScreen extends MainScreen {
    
    private JFrame frame;
    private FTSButton searchButton;
    private FTSTextField productID, history;

    public HistoryScreen (){
        super();
        frame = this.getFrame();
        addLabel("PRODUCT HISTORY");
        setSearch();
        addSearchButton();
        addReturnButton();
        frame.setVisible(true);
    }

    private void setSearch(){
        productID = new FTSTextField("Product ID", 40, 100, 600, 30);
        frame.getContentPane().add(productID);
    }

    private void addSearchButton (){
        searchButton = new FTSButton("GO", 680, 100, 60, 30, e -> showHistory());
        frame.getContentPane().add(searchButton);
    }

    private void showHistory (){
        history = new FTSTextField("History", 40, 150, 700, 230);
        frame.getContentPane().add(history);
    }

    @Override
    protected void callController (){}
}