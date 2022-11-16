package com.bookyourseat.api.Core.User.Model;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.bookyourseat.api.Crypto.PasswordHash;

public class User {

    private UUID Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;

    public UUID getUserId() {
        return Id;
    }

    public void setUserId(UUID userId) {
        Id = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        if (password != null) {
            try {
                this.Password = PasswordHash.hash(password);
            }
            catch(NoSuchAlgorithmException e) {
                System.out.println("Unable to set Password with hash");
            }
        }
    }
}
