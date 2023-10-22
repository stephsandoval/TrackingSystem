/* Stephanie Sandoval - Caso 02
 * RecordProcessor - In charge of serializing and deserializing objects
 */

package Records;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Packages.Package;

public class RecordProcessor {
    
    private String filename;

    public RecordProcessor(){}

    public void setFilename (String filename){
        this.filename = filename;
    }

    public void setFilename (int id){
        this.filename = Integer.toString(id);
    }

    public String getFilename (){
        return this.filename;
    }

    public void saveObject (Package clientPackage){
        filename = Integer.toString(clientPackage.getPackageID()) + ".fts";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(clientPackage);

            out.close();
            file.close();
        } catch (IOException ex){}
    }

    public Package getObject (int packageID){
        Package clientPackage = null;
        filename = Integer.toString(packageID) + ".fts";

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            clientPackage = (Package) in.readObject();

            in.close();
            file.close();
        } catch (IOException ex){} catch (ClassNotFoundException ex){}

        return clientPackage;
    }

    public boolean hasRecord (int packageID) {
        filename = Integer.toString(packageID) + ".txt";
        File file = new File(filename);
        return file.exists();
    }
}