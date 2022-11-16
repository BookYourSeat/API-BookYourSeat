package com.bookyourseat.api.Core.User.Model;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.bookyourseat.api.Crypto.PasswordHash;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    
    private UUID Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID userId) {
        Id = userId;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @JsonProperty("Password")
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
