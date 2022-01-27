package com.revature.dao;

import com.revature.models.Users;

import java.util.List;

public class Users_DAO_IMP implements IUsers_DAO{

    @Override
    public List<Users> selectAllUsers() {
        return null;
    }

    @Override
    public List<Users> selectUsersByUsername(String username) {
        return null;
    }

    @Override
    public Users selectUserByID(int id) {
        return null;
    }

    @Override
    public boolean insert(Users Users) {
        return false;
    }

    @Override
    public boolean update(Users Users) {
        return false;
    }
}
