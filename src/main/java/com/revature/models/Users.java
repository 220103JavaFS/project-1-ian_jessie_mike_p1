package com.revature.models;

import java.util.Objects;

public class Users {

    private Integer user_ID;
    private String user_Name;
    private String user_Pass;
    private String user_First_Name;
    private String user_Last_Name;
    private String user_Email;
    private Integer user_Role_ID;

    public Users() {
    }

    public Users(Integer user_ID, String user_Name, String user_Pass, String user_First_Name,
                 String user_Last_Name, String user_Email, Integer user_Role_ID) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.user_Pass = user_Pass;
        this.user_First_Name = user_First_Name;
        this.user_Last_Name = user_Last_Name;
        this.user_Email = user_Email;
        this.user_Role_ID = user_Role_ID;
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Pass() {
        return user_Pass;
    }

    public void setUser_Pass(String user_Pass) {
        this.user_Pass = user_Pass;
    }

    public String getUser_First_Name() {
        return user_First_Name;
    }

    public void setUser_First_Name(String user_First_Name) {
        this.user_First_Name = user_First_Name;
    }

    public String getUser_Last_Name() {
        return user_Last_Name;
    }

    public void setUser_Last_Name(String user_Last_Name) {
        this.user_Last_Name = user_Last_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public Integer getUser_Role_ID() {
        return user_Role_ID;
    }

    public void setUser_Role_ID(Integer user_Role_ID) {
        this.user_Role_ID = user_Role_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(getUser_ID(), users.getUser_ID()) && Objects.equals(getUser_Name(), users.getUser_Name()) && Objects.equals(getUser_Pass(), users.getUser_Pass()) && Objects.equals(getUser_First_Name(), users.getUser_First_Name()) && Objects.equals(getUser_Last_Name(), users.getUser_Last_Name()) && Objects.equals(getUser_Email(), users.getUser_Email()) && Objects.equals(getUser_Role_ID(), users.getUser_Role_ID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_ID(), getUser_Name(), getUser_Pass(), getUser_First_Name(), getUser_Last_Name(), getUser_Email(), getUser_Role_ID());
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_ID=" + user_ID +
                ", user_Name='" + user_Name + '\'' +
                ", user_Pass='" + user_Pass + '\'' +
                ", user_First_Name='" + user_First_Name + '\'' +
                ", user_Last_Name='" + user_Last_Name + '\'' +
                ", user_Email='" + user_Email + '\'' +
                ", user_Role_ID=" + user_Role_ID +
                '}';
    }
}
