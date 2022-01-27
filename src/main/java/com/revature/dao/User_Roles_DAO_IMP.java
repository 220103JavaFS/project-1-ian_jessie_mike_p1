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
    public User_Roles selectUserRoleByUserID(int id) {
        User_Roles roll = null;

        //Get DB connection and execute prepared statement
        try (Connection myConnect = DB_Connector.getConnection()){
            String sql = "SELECT user_role_id from users where user_id = ?;";
            PreparedStatement ps = myConnect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet queryResult = ps.executeQuery();

            Integer var = new Integer(0);
            while (queryResult.next()) {
                var = queryResult.getInt("user_role_id");
            }

            userRoleLog.info("found the user_role_id and set it to var");

            String sql2 = "SELECT * from roles where user_role_id = ?;";
            PreparedStatement ps2 = myConnect.prepareStatement(sql2);
            ps.setInt(1, var);
            ResultSet queryResult2 = ps.executeQuery();

            User_Roles user = new User_Roles();
            while(queryResult2.next()){
                user.setUser_Role_ID(queryResult2.getInt("user_role_id"));
                user.setUser_Role(queryResult2.getString("user_role"));
            }
            return user;
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
