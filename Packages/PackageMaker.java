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

    public void createPackage (){
        this.clientPackage = new Package(order.getDateProcessed(), order.getArrivalDate(), order.getClient().getClientID(), order.getEmployee().getEmployeeID(), prepackage.getBouquets(), order.getArrivalPlace(), "--", "here", this.calculatePrice(), true);
    }

    public Package getPackage (){
        return this.clientPackage;
    }

    public void addEvent (Event event){
        this.events.add(event);
    }
}