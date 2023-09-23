/* Stephanie Sandoval - Caso 02
 * Bouquet class - Holds information for a flower bouquet
 */

package Flowers;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> bouquet; // one entry per different flower
    private ArrayList<Integer> amounts; // amount of each different flower - same order as bouquet

    public Bouquet (ArrayList<Flower> flowers, ArrayList<Integer> amounts){
        this.bouquet = flowers;
        this.amounts = amounts;
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

        // deterine the amount of flowers given
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
        String objectDescription = "this bouquet contains :";
        for (Flower flower : bouquet){
            objectDescription += " - " + amounts.get(index++) + " flowers of type " + flower.getType() + " and species " + flower.getSpecies();
        }
        return objectDescription;
    }

    public static void main (String args[]){
        ArrayList<Flower> flowers = new ArrayList<>();
        ArrayList<Integer> amounts = new ArrayList<>();

        flowers.add(new Flower("rose", "hybrid tea", 10.0f));
        amounts.add(new Integer(6));

        Bouquet bouquet = new Bouquet(flowers, amounts);
        System.out.println(bouquet.toString());
        bouquet.addFlower(new Flower("carnation", "mini", 5.2f));
        bouquet.addFlower(new Flower("rose", "spray", 8.2f), 6);
        bouquet.addFlower(new Flower("carnation", "standar", 7.0f), 3, 4, 0);
        bouquet.addFlower(new Flower("carnation", "mini", 3.4f), 4);
        System.out.println(bouquet.toString());
    }
}