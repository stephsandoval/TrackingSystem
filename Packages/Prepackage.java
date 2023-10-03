package Packages;

import java.util.ArrayList;

import Flowers.Bouquet;

public class Prepackage {
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
        String objectDescription = "prepackage >> bouquets > ";
        for (Bouquet bouquet : bouquets){
            objectDescription += bouquet.toString() + " | ";
        }
        objectDescription += ">> prices > ";
        for (Float price : prices){
            objectDescription += "$" + price + " | ";
        }
        return objectDescription;
    }
}