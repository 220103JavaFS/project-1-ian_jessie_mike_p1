package com.revature.dao;

import com.revature.models.Reimbursement_Type;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reimbursement_Type_DAO_IMP implements IReimbursement_Type_DAO{

    private static final Logger reimbursementTypeLog = LoggerFactory.getLogger(User_Roles_DAO_IMP.class);


    @Override
    public String selectReimbursementTypeByID(int id) {

        //Get DB connection and execute prepared statement
        try (Connection myConnect = DB_Connector.getConnection()){
            String sql = "select * from reimbursement_type where type_id = ?;";
            PreparedStatement ps = myConnect.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet queryResult = ps.executeQuery();
            queryResult.next();
            return queryResult.getString("reimbursement_type");

        } catch (SQLException e){
            e.printStackTrace();
            reimbursementTypeLog.debug("Select reimbursement type by ID Failure!");
        }
        return null;
    }

}
