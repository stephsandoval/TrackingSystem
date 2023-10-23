/* Stephanie Sandoval - Caso 02
 * Bouquet class - Holds information for a flower bouquet
 */

package Flowers;

import java.util.ArrayList;
import java.io.Serializable;

public class Bouquet implements Serializable {

    private ArrayList<Flower> bouquet; // one entry per different flower
    private ArrayList<Integer> amounts; // amount of each different flower - same order as bouquet

    public Bouquet (ArrayList<Flower> flowers, ArrayList<Integer> amounts){
        this.bouquet = new ArrayList<>();
        this.amounts = new ArrayList<>();
        for (Flower flower : flowers){
            addFlower(flower, amounts.get(flowers.indexOf(flower)));
        }
    }

    public ArrayList<Flower> getBouquet (){
        return this.bouquet;
    }

    public ArrayList<Integer> getAmounts (){
        return this.amounts;
    }

    public void addFlower (Flower newFlower, int... flowerAmount){
        boolean inBouquet = false;
        int amountFlowers, index = 0;

        // check if the flower is already in the bouquet
        // do not allow duplicate objects
        for (Flower flower : bouquet){
            if (flower.equalTo(newFlower)){
                inBouquet = true;
                index = bouquet.indexOf(flower);
            }
        }

        // determine the amount of flowers given
        amountFlowers = getFlowerAmount(flowerAmount);

        // if the flower was in the bouquet
        if (inBouquet){
            // increase amount
            int newAmount = amounts.get(index) + amountFlowers;
            amounts.set(index, newAmount);
        } else {
            // otherwise, add flower and amount to the arraylists
            bouquet.add(newFlower);
            amounts.add(amountFlowers);
        }
    }

    private int getFlowerAmount (int... flowerAmount){
        int amount;
        if (flowerAmount.length == 0){
            // no parameter given, assume 1
            amount = 1;
        } else {
            // at least one parameter given, take first entry
            // absolute value to avoid negative numbers
            amount = (int) Math.abs(flowerAmount[0]);
        }
        return amount;
    }

    public String toString (){
        int index = 0;
        String objectDescription = "";
        for (Flower flower : bouquet){
            objectDescription += " - " + amounts.get(index++) + " " + flower.getSpecies() + " " + flower.getType();
        }
        return objectDescription;
    }
}