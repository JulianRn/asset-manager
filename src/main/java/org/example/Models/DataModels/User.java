package org.example.Models.DataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private String username;

    private String password;

    private ArrayList<Investment> userInvestments;

    public User(String firstName, String lastName, String username, String password)  {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this. userInvestments = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Investment> getUserInvestments() {
        return userInvestments;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String username) {
        this.username = username;
    }
}
