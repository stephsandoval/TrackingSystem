package Packages;

import java.util.ArrayList;

import Orders.Order;

public class PackageMaker {
    private Prepackage prepackage;
    private Package clientPackage;
    //private Event event;
    private Order order;

    public PackageMaker (Order order, Prepackage prepackage){
        this.prepackage = prepackage;
        this.order = order;
    }

    private float calculatePrice (){
        float totalPrice = 0;
        ArrayList <Float> prices = prepackage.getPrices();
        for (Float price : prices){
            totalPrice += price;
        }
        return totalPrice;
    }

    public void createPackage (){
        this.clientPackage = new Package(order.getDateProcessed(), order.getArrivalDate(), order.getClient().getClientID(), order.getEmployee().getEmployeeID(), prepackage.getBouquets(), order.getArrivalPlace(), "--", "here", this.calculatePrice(), true);
    }

    public Package getPackage (){
        return this.clientPackage;
    }

    public void addEvent (){
        // create event and add it to the package events
    }
}