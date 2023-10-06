/* Stephanie Sandoval - Flower tracking system
 * Main class for console testing
 */

import java.time.LocalDate;
import java.util.ArrayList;

import Flowers.Flower;
import Orders.Order;
import Orders.OrderMaker;
import Packages.PackageMaker;
import Packages.Prepackage;
import People.Client;
import People.Employee;
import Packages.IDGenerator;
import Packages.Package;

public class Driver {

    public static void main (String args[]){
        ArrayList <Flower> bouquet1 = new ArrayList <Flower> ();
        bouquet1.add(new Flower("rose", "hybrid tea", 34));
        bouquet1.add(new Flower("carnation", "standard", 32));

        ArrayList <Integer> bouquet1Amounts = new ArrayList<>();
        bouquet1Amounts.add(6);
        bouquet1Amounts.add(6);

        ArrayList <Flower> bouquet2 = new ArrayList <Flower> ();
        bouquet2.add(new Flower("rose", "sweetheart", 8));
        bouquet2.add(new Flower("rose", "sweetheart", 9));

        ArrayList <Integer> bouquet2Amounts = new ArrayList<>();
        bouquet2Amounts.add(8);
        bouquet2Amounts.add(4);

        ArrayList <ArrayList <Flower>> orderFlowers = new ArrayList<>();
        orderFlowers.add(bouquet1);
        orderFlowers.add(bouquet2);

        ArrayList <ArrayList <Integer>> orderAmounts = new ArrayList<>();
        orderAmounts.add(bouquet1Amounts);
        orderAmounts.add(bouquet2Amounts);

        String arrivalPlace = "Canada";
        LocalDate arrivalDate =  LocalDate.of(2023, 10, 10);
        LocalDate dateProcessed = LocalDate.of(2023, 10, 5);

        Client client = new Client("Olaf", IDGenerator.getInstance().getNewID(), null);
        Employee employee = new Employee("Pete", IDGenerator.getInstance().getNewID(), "FTS");

        Order order = new Order(orderFlowers, orderAmounts, arrivalPlace, arrivalDate, dateProcessed, client, employee);
        client.setOrder(order);
        OrderMaker orderMaker = new OrderMaker(order);

        Prepackage prepackage = orderMaker.getPrepackage();
        System.out.println(prepackage.toString() + "\n\n");

        PackageMaker packageMaker = new PackageMaker(order, prepackage);
        Package clientPackage = packageMaker.getPackage();
        clientPackage.addNote("testing the methods");

        System.out.println(clientPackage.toString());
    }
}