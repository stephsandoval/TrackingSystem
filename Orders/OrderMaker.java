/* Stephanie Sandoval - Caso 02
 * OrderMaker - Class in charge of preparing the orders
 * Basically, the one that puts the bouquets and amounts in a single object
 * And calculates the prices of the flowers based on the catalogue information
 */

package Orders;

import java.time.LocalDate;
import java.util.ArrayList;

import Flowers.Bouquet;
import Flowers.Catalogue;
import Flowers.Flower;
import Packages.Prepackage;
import People.Client;
import People.Employee;

public class OrderMaker {
    private ArrayList <Bouquet> bouquets;
    private ArrayList <Float> prices;
    private Catalogue catalogue;
    private Order order;
    private Prepackage prepackage;

    private ArrayList <ArrayList <Flower>> flowers;
    private ArrayList <ArrayList <Integer>> amounts;

    public OrderMaker (Order order){
        this.order = order;
        this.bouquets = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.catalogue = new Catalogue();
        processOrder();
        createBouquets();
        calculatePrices();
    }

    private void processOrder (){
        this.flowers = order.getFlowers();
        this.amounts = order.getAmounts();
    }
    
    private void createBouquets (){
        Bouquet newBouquet;
        for (ArrayList <Flower> flower : flowers){
            newBouquet = new Bouquet(flower, amounts.get(flowers.indexOf(flower)));
            bouquets.add(newBouquet);
        }
    }

    private void calculatePrices (){
        ArrayList <Flower> flowerList;
        float bouquetPrice;
        for (Bouquet bouquet : bouquets){
            bouquetPrice = 0;
            flowerList = bouquet.getBouquet();
            for (Flower flower : flowerList){
                bouquetPrice += catalogue.getPrice(flower) * amounts.get(bouquets.indexOf(bouquet)).get(flowerList.indexOf(flower));
            }
            prices.add(bouquetPrice);
        }
    }

    private void createPrepackage (){
        this.prepackage = new Prepackage(bouquets, prices);
    }

    public Prepackage getPrepackage (){
        createPrepackage();
        return this.prepackage;
    }
    
    public void printPrices (){
        for (Float price : prices){
            System.out.println("Price of bouquet : " + price);
        }
    }

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
        LocalDate dateProcessed = LocalDate.of(2023, 10, 2);

        Client client = new Client("Olaf", 145520025, null);
        Employee employee = new Employee("Pete", 14587725, "FTS");

        // note: should the client contain the order or the order the client?

        Order order = new Order(orderFlowers, orderAmounts, arrivalPlace, arrivalDate, dateProcessed, client, employee);
        OrderMaker orderMaker = new OrderMaker(order);

        Prepackage prepackage = orderMaker.getPrepackage();
        System.out.println(prepackage.toString());
    }
}