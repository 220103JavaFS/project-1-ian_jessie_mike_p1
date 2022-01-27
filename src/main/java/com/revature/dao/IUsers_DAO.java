package com.revature.dao;

import com.revature.models.Users;

import java.util.List;

public interface IUsers_DAO {

    //Admin functionality
    List<Users> selectAllUsers();

    //Admin functionality
    Users selectUserByUsername(String username);


    //List<Users> selectUsersByRoleID(Users users);

    Users selectUserByID(int id);

    boolean insert(Users Users);

    boolean update(Users Users);

    //boolean delete(Users Users);

}
