package Packages;

import java.util.ArrayList;

import Events.Event;
import Flowers.Bouquet;

public class PackagePreviewMaker {
 
    private ArrayList <PackagePreview> preview;
    private Package clientPackage;

    public PackagePreviewMaker (Package clientPackage){
        this.clientPackage = clientPackage;
        this.preview = new ArrayList<>();
        createPreview();
    }

    private void createPreview (){
        preview.add(new PackagePreview("date processed", clientPackage.getDateProcessed().toString()));
        preview.add(new PackagePreview("arrival date", clientPackage.getArrivalDate().toString()));
        preview.add(new PackagePreview("package id", Integer.toString(clientPackage.getPackageID())));
        addClient();
        addEmployee();
        addBouquet();
        preview.add(new PackagePreview("arrival place", clientPackage.getArrivalPlace()));
        preview.add(new PackagePreview("location", clientPackage.getLocation()));
        addNote();
        preview.add(new PackagePreview("price", Float.toString(clientPackage.getPrice())));
        preview.add(new PackagePreview("complete", Boolean.toString(clientPackage.isComplete())));
    }

    public ArrayList <PackagePreview> getPreview (){
        return this.preview;
    }

    private void addNote (){
        ArrayList <String> notes = clientPackage.getNotes();
        for (String note : notes){
            preview.add(new PackagePreview("note", note));
        }
    }

    private void addBouquet (){
        ArrayList <Bouquet> bouquets = clientPackage.getBouquets();
        for (Bouquet bouquet : bouquets){
            preview.add(new PackagePreview("bouquet", bouquet.toString()));
        }
    }

    private void addClient (){
        preview.add(new PackagePreview("client name", clientPackage.getClient().getName()));
        preview.add(new PackagePreview(" > id", Integer.toString(clientPackage.getClient().getClientID())));
    }

    private void addEmployee (){
        preview.add(new PackagePreview("employee name", clientPackage.getEmployee().getName()));
        preview.add(new PackagePreview(" > company", clientPackage.getEmployee().getCompany()));
        preview.add(new PackagePreview(" > id", Integer.toString(clientPackage.getEmployee().getEmployeeID())));
    }
}