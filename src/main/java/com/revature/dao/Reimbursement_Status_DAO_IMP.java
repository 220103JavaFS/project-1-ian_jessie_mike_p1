package com.revature.dao;

import com.revature.models.Reimbursement_Status;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reimbursement_Status_DAO_IMP implements IReimbursement_Status_DAO{

    private static final Logger reimbursementStatusLog = LoggerFactory.getLogger(User_Roles_DAO_IMP.class);


    @Override
    public String selectReimbursementStatusByID(int id) {

        //Get DB connection and execute prepared statement
        try (Connection myConnect = DB_Connector.getConnection()){
            String sql = "select * from reimbursement_status where status_id = ?;";
            PreparedStatement ps = myConnect.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet queryResult = ps.executeQuery();
            queryResult.next();
            return queryResult.getString("status");

        } catch (SQLException e){
            e.printStackTrace();
            reimbursementStatusLog.debug("Select reimbursement status by ID Failure!");
        }
        return null;
    }
}
