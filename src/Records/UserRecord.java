package Records;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRecord {

    private static UserRecord instance;
    private ArrayList <User> users;

    private UserRecord (){
        users = new ArrayList<>();
        loadRecord();
    }

    public static synchronized UserRecord getInstance (){
        if (instance == null){
            instance = new UserRecord();
        }
        return instance;
    }

    private void loadRecord (){
        Scanner scan = null;
        try {
            scan = new Scanner(new File("C:\\Users\\Stephanie\\OneDrive - Estudiantes ITCR\\Semestre II\\Programación Orientada a Objetos\\Caso 02\\Flower Tracking System\\src\\Records\\users.txt"));
        } catch (Exception e){}
        scan.useDelimiter("\n");
        while (scan.hasNext()){
            createMap(scan.next());
        }
        scan.close();
    }

    private void createMap (String recordLine){
        String[] data = recordLine.split(",", 2);
        this.users.add(new User(data[1], Integer.valueOf(data[0])));
    }

    public boolean hasUser (String userName, int password){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUserName() == userName && users.get(i).getPassword() == password){
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args){
        System.out.println(UserRecord.getInstance().hasUser("ftssandoval", 1234));
    }
}