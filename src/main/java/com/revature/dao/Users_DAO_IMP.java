package com.revature.dao;

import com.revature.models.User_Roles;
import com.revature.models.Users;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Users_DAO_IMP implements IUsers_DAO{

    private static final Logger userLog = LoggerFactory.getLogger(Users_DAO_IMP.class);

//    @Override
//    public List<Users> selectAllUsers() {
//        return null;
//    }

    @Override
    public List<Users> selectAllUsers() {
        return null;
    }

    @Override
    public Users selectUserByUsername(String username) {
        try (Connection myConnect = DB_Connector.getConnection()){
            String sql = "SELECT * FROM users where user_name = ?;";

            PreparedStatement ps = myConnect.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet queryResult = ps.executeQuery();

            userLog.info("Select user by username query executed!");

            Users user = new Users();
            while (queryResult.next()) {
                user.setUser_ID(queryResult.getInt("user_id"));
                user.setUser_Name(queryResult.getString("user_name"));
                user.setUser_Pass(queryResult.getString("user_pass"));
                user.setUser_First_Name(queryResult.getString("user_first_name"));
                user.setUser_Last_Name(queryResult.getString("user_last_name"));
                user.setUser_Email(queryResult.getString("user_email"));
                user.setUser_Role_ID(queryResult.getInt("user_role_id"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            userLog.debug("Select user role by username Failure!");
        }
        return null;
    }

    @Override
    public Users selectUserByID(int id) {
        try (Connection myConnect = DB_Connector.getConnection()){
            PreparedStatement ps = myConnect.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?;");
            ps.setInt(1, id);
            ResultSet queryResult = ps.executeQuery();

            userLog.info("Select user role by user ID query executed!");

            Users user = new Users();
            while (queryResult.next()) {
                user.setUser_ID(queryResult.getInt("user_id"));
                user.setUser_Name(queryResult.getString("user_name"));
                user.setUser_Pass(queryResult.getString("user_pass"));
                user.setUser_First_Name(queryResult.getString("user_first_name"));
                user.setUser_Last_Name(queryResult.getString("user_last_name"));
                user.setUser_Email(queryResult.getString("user_email"));
                user.setUser_Role_ID(queryResult.getInt("user_role_id"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            userLog.debug("Select user role by username Failure!");
        }
        return null; 
    }

    @Override
    public boolean insert(Users users) {
        try (Connection myConnect = DB_Connector.getConnection()){
            PreparedStatement ps = myConnect.prepareStatement(
                    "INSERT into users (user_name, user_pass, user_first_name," +
                            " user_last_name, user_email, user_role_id) values (?,?,?,?,?,?);");

            ps.setString(1, users.getUser_Name());
            ps.setString(2, users.getUser_Pass());
            ps.setString(3, users.getUser_First_Name());
            ps.setString(4, users.getUser_Last_Name());
            ps.setString(5, users.getUser_Email());
            ps.setInt(6,users.getUser_Role_ID());
            ps.execute();
            return true;

    }catch(SQLException e){
            e.printStackTrace();
            userLog.debug("Insert User failed!!");
        }
        return false;
    }

    @Override
    public boolean update(Users users) {
        try (Connection myConnect = DB_Connector.getConnection()){
            PreparedStatement ps = myConnect.prepareStatement(
                    "UPDATE users  set user_name = ?, user_pass = ?, user_first_name = ?," +
                            " user_last_name = ?, user_email = ?, user_role_id = ? where user_id = ?");

            ps.setString(1, users.getUser_Name());
            ps.setString(2, users.getUser_Pass());
            ps.setString(3, users.getUser_First_Name());
            ps.setString(4, users.getUser_Last_Name());
            ps.setString(5, users.getUser_Email());
            ps.setInt(6,users.getUser_Role_ID());
            ps.setInt(7, users.getUser_ID());
            ps.execute();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            userLog.debug("Insert User failed!!");
        }
        return false;    }
}
