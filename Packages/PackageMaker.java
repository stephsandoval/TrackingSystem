/* Stephanie Sandoval - Caso 02
 * Package Maker class - Creates the packages of the order
 * Creates the final version (the one to be shipped)
 */

package Packages;

import java.util.ArrayList;

import Events.Event;
import Orders.Order;

public class PackageMaker {
    private Prepackage prepackage;
    private Package clientPackage;
    private ArrayList <Event> events;
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

    private void createPackage (){
        this.clientPackage = new Package(order.getDateProcessed(), order.getArrivalDate(), order.getClient().getClientID(), order.getEmployee().getEmployeeID(), prepackage.getBouquets(), order.getArrivalPlace(), "shipping", "FTS", this.calculatePrice(), true);
    }

    public Package getPackage (){
        this.createPackage();
        ArrayList <String> description = new ArrayList<>();
        description.add("package created - sent to shipping");
        Event event = new Event(order.getDateProcessed(), order.getEmployee().getCompany(), order.getEmployee().getCompany(), description);
        clientPackage.addEvent(event);
        return this.clientPackage;
    }

    public void addEvent (Event event){
        this.events.add(event);
    }
}