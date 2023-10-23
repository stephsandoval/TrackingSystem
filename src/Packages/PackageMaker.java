/* Stephanie Sandoval - Caso 02
 * Package Maker class - Creates the packages of the order
 * Creates the final version (the one to be shipped)
 */

package Packages;

import java.util.ArrayList;

import Events.Event;
import Orders.Order;
import Records.RecordProcessor;

public class PackageMaker {
    private Prepackage prepackage;
    private Package clientPackage;
    private ArrayList <Event> events;
    private Order order;
    private boolean complete;

    public PackageMaker (Order order, Prepackage prepackage, boolean complete){
        this.prepackage = prepackage;
        this.order = order;
        this.complete = complete;
        createPackage();
    }

    private float calculatePrice (){
        float totalPrice = 0;
        ArrayList <Float> prices = prepackage.getPrices();
        for (Float price : prices){
            totalPrice += price;
        }
        return totalPrice;
    }

    private void createPackage (){
        clientPackage = new Package(order.getDateProcessed(), order.getArrivalDate(), order.getClient(), order.getEmployee(), prepackage.getBouquets(), order.getArrivalPlace(), order.getEmployee().getCompany(), this.calculatePrice(), complete);
        ArrayList <String> description = new ArrayList<>();
        description.add("package created - sent to shipping");
        Event event = new Event(order.getDateProcessed(), order.getEmployee().getCompany(), order.getEmployee().getCompany(), "in process", description);
        clientPackage.addEvent(event);
        new RecordProcessor().saveObject(clientPackage);
    }

    public Package getPackage (){
        return this.clientPackage;
    }

    public void addEvent (Event event){
        this.events.add(event);
    }
}