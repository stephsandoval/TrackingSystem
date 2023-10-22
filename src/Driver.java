/* Stephanie Sandoval - Flower tracking system
 * Main class for console testing
 */

 /* ACUERDO DEL SISTEMA
  * 1. ingresar el pedido con un número como decis, ahi va la información de las rosas, precios y todo. 
  * El pedido se ingresa en estado "en proceso"
  * 2. actualizacion de pedido y estado, cuando el pedido ya sale, pasa a shipping, luego out to delivery
  * finalmente delivery, incluso podría haber uno de perdido o devuelto o dañado
  * hacemos q el json configure bajo algun rate que algunos pedidos aleatoriamente los dañe o se pierdan
  * 3. cuando el usuario hace un update o cambia un esatdo debe ingresar la empresa carrier, la ubicación
  * y notas por decir algo, eso sucede ahi mismo en el paso 2
  * 4. finalmente tenemos una ventana para dado el número del pedido ver el historial por el que el ha pasado a la fecha
  */

/* ACUERDO PARA EL SEGUNDO AVANCE
 * Para este preliminar la idea sería implementar todas las clases del sistema principal. 
 * Esto quiere decir, no tocar nada de GUI ni de los controladores que pegan el sistema contra el GUI. 
 * Tampoco se implementaría la clase para leer el json por el momento (ni el archivo json).
 * Gráficamente, se implementarían las clases que en el diagrama aparecen del Package Manager hacia bajo (inclusive). 
 * Entonces, las clases son: 
 * + Package Manager
 * + Event
 * + Package Maker
 * + Record Processor (se hizo una actualizacion del alcance del avance y esta ya no se incluye)
 * + Pre Package
 * + Package
 * + Order
 * + Order Maker
 * + Client
 * + Employee
 * + Catalogue
 * + Bouquet
 * + Flower
 * Dado que todavía no se conecta contra GUI ni se lee del json, por el momento se utilizarían datos "hard-coded" 
 * para probar que las clases sirvan y se conecten bien. Además, métodos que imfluyen mucho con el GUI, 
 * por ejemplo, el TakeOrder() del Employee serían muy muy básicos 
 * porque implementarlos para consola implicaría mucha lógica que luego al montarlo contra GUI no serviría de mucho.
 * NOTA : se hizo una actualizacion del alcance del avance y la clase Record Processor no va en la entrega
 */

import java.time.LocalDate;
import java.util.ArrayList;

import Flowers.Flower;
import Orders.Order;
import Orders.OrderMaker;
import Packages.PackageMaker;
import Packages.PackageManager;
import Packages.Prepackage;
import People.Client;
import People.Employee;
import Packages.IDGenerator;
import Packages.Package;

public class Driver {

    public static void main (String args[]){
        ArrayList <Flower> bouquet1 = new ArrayList <Flower> ();
        bouquet1.add(new Flower("rose", "hybrid tea", 34));
        bouquet1.add(new Flower("rose", "spray", 32));
        bouquet1.add(new Flower("rose", "sweetheart", 32));

        ArrayList <Integer> bouquet1Amounts = new ArrayList<>();
        bouquet1Amounts.add(6);
        bouquet1Amounts.add(6);
        bouquet1Amounts.add(6);

        ArrayList <Flower> bouquet2 = new ArrayList <Flower> ();
        bouquet2.add(new Flower("carnation", "standard", 8));
        bouquet2.add(new Flower("carnation", "mini", 9));
        bouquet2.add(new Flower("carnation", "hybrid", 9));

        ArrayList <Integer> bouquet2Amounts = new ArrayList<>();
        bouquet2Amounts.add(8);
        bouquet2Amounts.add(4);
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

        Client client = new Client("Olaf", IDGenerator.getInstance().getNewID());
        Employee employee = new Employee("Pete", IDGenerator.getInstance().getNewID(), "FTS");

        Order order = new Order(orderFlowers, orderAmounts, arrivalPlace, arrivalDate, dateProcessed, client, employee);
        OrderMaker orderMaker = new OrderMaker(order);

        Prepackage prepackage = orderMaker.getPrepackage();
        System.out.println(prepackage.toString() + "\n\n");

        PackageMaker packageMaker = new PackageMaker(order, prepackage, orderMaker.isComplete());
        Package clientPackage = packageMaker.getPackage();
        clientPackage.addNote("testing the methods");

        ArrayList <String> description = new ArrayList<>();
        description.add("Trying the object serialization");
        LocalDate today = LocalDate.of(2023, 10, 10);
        String location = "Pacific Ocean";
        String company = "FTS - BOATS";

        System.out.println(clientPackage.toString());

        PackageManager packageManager = new PackageManager();
        packageManager.setPackage(clientPackage);
        packageManager.updateObject(today, location, company, description);

        Package p = packageManager.getObject(clientPackage.getPackageID());
        System.out.println("\n\n" + p.toString());
    }
}