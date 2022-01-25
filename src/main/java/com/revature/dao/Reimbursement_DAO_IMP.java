package com.revature.dao;

import com.revature.Application;
import com.revature.models.Reimbursement;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reimbursement_DAO_IMP implements IReimbursement_DAO{

//    private static final Logger reimbursementLog = LoggerFactory.getLogger(Application.class);


    @Override
    public List<Reimbursement> select_All_Reimbursements() {
        List<Reimbursement> reimbursements = new ArrayList<>();

        return reimbursements;
    }

    @Override
    public List<Reimbursement> select_All_Reimbursements_By_User_ID(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> select_Reimbursement_By_Status_ID(int status_ID) {
        return null;
    }

    @Override
    public Reimbursement select_Reimbursement_By_ID(int id) {
        return null;
    }

    @Override
    public boolean insert(Reimbursement reimbursement) {

        boolean updated = false;

        try {
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "INSERT into reimbursement (reimbursement_Amount, time_Submitted," +
                            " time_Resolved, description, reciept, author_ID, resolver_ID, status_ID, type_ID) values (?,?,?,?,?,?,?,?,?)");

            ps.setFloat(1, reimbursement.getReimbursement_Amount());
            ps.setTimestamp(2, reimbursement.getTime_Submitted());
            ps.setTimestamp(3, reimbursement.getTime_Resolved());
            ps.setString(4, reimbursement.getDescription());
            ps.setBytes(5, reimbursement.getReciept());
            ps.setInt(6, reimbursement.getAuthor_ID());
            ps.setInt(7, reimbursement.getResolver_ID());
            ps.setInt(8, reimbursement.getStatus_ID());
            ps.setInt(9, reimbursement.getType_ID());
            ps.execute();
            updated = true;

        } catch (SQLException e) {
            e.printStackTrace();
//            reimbursementLog.info("Reimbursement insert failed");
        }
        return updated;
    }

        @Override
    public boolean update(Reimbursement reimbursement) {
        return false;
    }

//    @Override
//    public boolean delete(Reimbursement reimbursement) {
//        return false;
//    }

    //    @Override
//    public List<Reimbursement> select_Reimbursement_By_Author(Users users) {
//        return null;
//    }
//
//    @Override
//    public List<Reimbursement> select_Reimbursement_By_Resolver(Users users) {
//        return null;
//    }

}
