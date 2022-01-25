package com.revature.dao;

import com.revature.models.User_Roles;

import java.util.List;

public class User_Roles_DAO_IMP implements IUser_Roles_DAO{

    @Override
    public User_Roles selectUserRoleByUserID(int id) {
        return null;
    }

    @Override
    public List<User_Roles> selectAllUserRolls() {
        return null;
    }

    @Override
    public boolean insertUserRole(User_Roles user_roles) {
        return false;
    }

    @Override
    public boolean updateUserRole(User_Roles user_roles) {
        return false;
    }

    @Override
    public boolean deleteUserRole(User_Roles user_roles) {
        return false;
    }
}
