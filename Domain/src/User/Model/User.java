package User.Model;

import java.util.UUID;

public class User {
    private UUID UserId;
    private String Name;
    private String Password;

    public User(){}

    public void SetUserID(UUID id){
        this.UserId = id;
    }

    public UUID GetUserId(){
        return this.UserId;
    }

    public void SetName(String name){
        this.Name = name;
    }

    public String GetName(){
        return this.Name;
    }

    public void SetPassword(String password){
        this.Password = password;
    }

    public String GetPassword(){
        return this.Password;
    }

}
