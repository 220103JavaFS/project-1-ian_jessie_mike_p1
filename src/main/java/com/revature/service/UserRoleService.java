package com.revature.service;
import com.revature.dao.IUser_Roles_DAO;
import com.revature.dao.User_Roles_DAO_IMP;

public class UserRoleService {

    private final IUser_Roles_DAO user_roles_dao;

    public UserRoleService(){user_roles_dao = new User_Roles_DAO_IMP();}

    public String SelectUserRoleByRoleID(int id){return user_roles_dao.selectUserRoleByRoleID(id);}
}
