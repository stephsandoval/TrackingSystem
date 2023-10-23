/* Stephanie Sandoval - Caso 02
 * Catalogue class - Holds the prices for each range of stem length for each flower species
 */

package Flowers;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalogue {
    private static Catalogue instance;
    private ArrayList<CatalogueEntry> entries;
    
    private Catalogue (){
        entries = new ArrayList<>();
        loadCatalogue();
    }

    public static synchronized Catalogue getInstance (){
        // only allow one instance of this object
        // this, to ensure there are no repeated IDs
        if (instance == null){
            instance = new Catalogue();
        }
        return instance;
    }

    private void loadCatalogue (){
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\Stephanie\\OneDrive - Estudiantes ITCR\\Semestre II\\Programación Orientada a Objetos\\Caso 02\\Flower Tracking System\\src\\Flowers\\catalogue.csv"));
        } catch (Exception e) {}
        scan.useDelimiter("\n"); // read up to the new line character
        scan.next(); // skip header line
        while (scan.hasNext()){
            createEntry(scan.next());
        }
        scan.close();
    }

    private void createEntry (String catalogueLine){
        String[] data = catalogueLine.split(",", 6);
        Flower flower = new Flower(data[0], data[1], 0);
        Range stemRange = new Range(Float.parseFloat(data[2]), Float.parseFloat(data[3]));
        Range priceRange = new Range(Float.parseFloat(data[4]), Float.parseFloat(data[5]));
        entries.add(new CatalogueEntry(flower, priceRange, stemRange));
    }

    public float getPrice (Flower flower){
        float flowerPrice;
        int flowerIndex = indexOf(flower);
        if (flowerIndex == -1){
            return 0;
        }
        CatalogueEntry flowerEntry = entries.get(flowerIndex);
        flowerPrice = calculatePrice(flower, flowerEntry);
        return flowerPrice;
    }

    private float calculatePrice (Flower flower, CatalogueEntry flowerEntry){
        float stemLength, minimumPrice, maximumPrice, minimumLength, maximumLength, actualPrice, percentage;
        stemLength = flower.getStemLength();
        minimumPrice = flowerEntry.getPriceRange().getMinimum();
        maximumPrice = flowerEntry.getPriceRange().getMaximum();
        minimumLength = flowerEntry.getStemRange().getMinimum();
        maximumLength = flowerEntry.getStemRange().getMaximum();
        percentage = (stemLength - minimumLength) / (maximumLength - minimumLength);
        actualPrice = percentage * (maximumPrice - minimumPrice) + minimumPrice;
        return actualPrice;
    }

    private int indexOf (Flower flower){
        for (CatalogueEntry entry : entries){
            if (entry.contains(flower)){
                return entries.indexOf(entry);
            }
        }
        return -1;
    }

    public boolean contains (Flower flower){
        if (indexOf(flower) == -1){
            return false;
        }
        return true;
    }
}