package model;

import java.util.ArrayList;

public class User  {
    private int id ;
    private String Username;
    private String Password;
    private String Fullname;
    private String Role;
    public User() {
    }
    public User(int id, String username, String password, String fullname, String role) {

        this.id = id;
        Username = username;
        Password = password;
        Fullname = fullname;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public String getRole() {
        return Role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public void setRole(String role) {
        Role = role;
    }
}

