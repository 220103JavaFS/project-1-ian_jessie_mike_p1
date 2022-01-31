package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.User_Roles;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_Roles_DAO_IMP implements IUser_Roles_DAO{

    private static final Logger userRoleLog = LoggerFactory.getLogger(User_Roles_DAO_IMP.class);

    @Override
    public String selectUserRoleByRoleID(int id) {

        //Get DB connection and execute prepared statement
        try (Connection myConnect = DB_Connector.getConnection()){
            String sql = "SELECT * from user_roles where user_role_id = ?;";
            PreparedStatement ps = myConnect.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet queryResult = ps.executeQuery();
            queryResult.next();
            return queryResult.getString("user_role");

        } catch (SQLException e){
            e.printStackTrace();
            userRoleLog.debug("Select user role by ID Failure!");
        }
        return null;
    }

//    @Override
//    public boolean insertUserRole(User_Roles user_roles) {
//        return false;
//    }

//    @Override
//    public boolean updateUserRole(User_Roles user_roles) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteUserRole(User_Roles user_roles) {
//        return false;
//    }
    //    @Override
//    public List<User_Roles> selectAllUserRolls() {
//        return null;
//    }


}
