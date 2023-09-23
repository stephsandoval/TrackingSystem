/* Stephanie Sandoval - Caso 02
 * CatalogueEntry class - Holds information for each entry in the catalogue
 * Each entry contains a flower, a stem range, and a price range
 */

package Flowers;

public class CatalogueEntry {
    private Flower flower;
    private Range priceRange;
    private Range stemRange;

    public CatalogueEntry (Flower flower, Range priceRange, Range stemRange){
        this.flower = flower;
        this.priceRange = priceRange;
        this.stemRange = stemRange;
    }

    public Flower getFlower (){
        return this.flower;
    }

    public Range getPriceRange (){
        return this.priceRange;
    }

    public Range getStemRange (){
        return this.stemRange;
    }

    public void setFlower (Flower flower){
        this.flower = flower;
    }

    public void setPriceRange (Range priceRange){
        this.priceRange = priceRange;
    }

    public void setStemRange (Range stemRange){
        this.stemRange = stemRange;
    }

    public String toString (){
        String objectDescription = "entry > for the " + flower.toString();
        objectDescription += " with stem length in " + stemRange.toString();
        objectDescription += " the price is in " + priceRange.toString();
        return objectDescription;
    }

    public boolean contains (Flower newFlower){
        boolean equalFlower = flower.equalTo(newFlower);
        System.out.println(equalFlower);
        return equalFlower;
    }
}