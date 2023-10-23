/* Stephanie Sandoval - Caso 02
 * Prepackage class - Holds information for the prepackages (bouquets and prices)
 * It is like a mini version of the final package
 */

package Packages;

import java.util.ArrayList;
import java.io.Serializable;

import Flowers.Bouquet;

public class Prepackage implements Serializable {
    private ArrayList <Bouquet> bouquets;
    private ArrayList <Float> prices;

    public Prepackage (ArrayList <Bouquet> bouquets, ArrayList <Float> prices){
        this.bouquets = bouquets;
        this.prices = prices;
    }

    public ArrayList <Bouquet> getBouquets (){
        return this.bouquets;
    }

    public ArrayList <Float> getPrices (){
        return this.prices;
    }

    public void setBouquets (ArrayList <Bouquet> bouquets){
        this.bouquets = bouquets;
    }

    public void setPrices (ArrayList <Float> prices){
        this.prices = prices;
    }

    public String toString (){
        String objectDescription = "prepackage >>> \n bouquets >> ";
        for (Bouquet bouquet : bouquets){
            objectDescription += bouquet.toString() + " | ";
        }
        objectDescription += "\n prices > ";
        for (Float price : prices){
            objectDescription += "$" + price + " | ";
        }
        return objectDescription;
    }
}