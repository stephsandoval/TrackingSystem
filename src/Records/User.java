package Records;

public class User {
    
    private String userName;
    private int password;

    public User (String userName, int password){
        this.userName = userName;
        this.password = password;
    }

    public void setUserName (String userName){
        this.userName = userName;
    }

    public void setPassword (int password){
        this.password = password;
    }

    public String getUserName (){
        return this.userName;
    }

    public int getPassword (){
        return this.password;
    }

    public String toString (){
        return userName + " " + password;
    }
}