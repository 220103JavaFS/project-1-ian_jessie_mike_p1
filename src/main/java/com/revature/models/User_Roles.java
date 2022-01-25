package com.revature.models;

import java.util.Objects;

public class User_Roles {

    private Integer user_Role_ID;
    private String user_Role;

    public Integer getUser_Role_ID() {
        return user_Role_ID;
    }

    public void setUser_Role_ID(Integer user_Role_ID) {
        this.user_Role_ID = user_Role_ID;
    }

    public String getUser_Role() {
        return user_Role;
    }

    public void setUser_Role(String user_Role) {
        this.user_Role = user_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User_Roles)) return false;
        User_Roles that = (User_Roles) o;
        return Objects.equals(getUser_Role_ID(), that.getUser_Role_ID()) && Objects.equals(getUser_Role(), that.getUser_Role());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_Role_ID(), getUser_Role());
    }

    @Override
    public String toString() {
        return "User_Roles{" +
                "user_Role_ID=" + user_Role_ID +
                ", user_Role='" + user_Role + '\'' +
                '}';
    }
}
