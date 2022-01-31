package com.revature.dao;

import com.revature.Application;
import com.revature.models.Reimbursement;
import com.revature.utils.DB_Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Reimbursement_DAO_IMP implements IReimbursement_DAO{

    private static final Logger reimbursementLog = LoggerFactory.getLogger(Reimbursement_DAO_IMP.class);



    @Override
    public List<Reimbursement> select_All_Reimbursements() {
        List<Reimbursement> reimbursementList = new ArrayList<>();

        //Create connection and perform select query
        try{
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "SELECT * from reimbursement");

            //Get results from query and construct Reimbursement list
            ResultSet queryResult = ps.executeQuery();
            while(queryResult.next()){

                Integer reID = queryResult.getInt("reimbursement_id");
                float amount = queryResult.getFloat("reimbursement_amount");
                String timesubmitted = queryResult.getString("time_submitted");
                String timeresolved = queryResult.getString("time_resolved");
                String description = queryResult.getString("description");
                byte[] reciept = queryResult.getBytes("reciept");
                Integer authorID = queryResult.getInt("author_id");
                Integer resolverID = queryResult.getInt("resolver_id");
                Integer statusID = queryResult.getInt("status_id");
                Integer typeID = queryResult.getInt("type_id");

                //create new reimbursement and add to the reimbursement list
                Reimbursement reimbursement = new Reimbursement(reID ,amount, timesubmitted,timeresolved,description,
                        reciept,authorID,resolverID,statusID, typeID);
                reimbursementList.add(reimbursement);
            }


        }catch(SQLException e){
            e.printStackTrace();
            reimbursementLog.debug("Select All Reimbursements failed!!!");

        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> select_All_Reimbursements_By_Author_ID(Integer id) {

        List<Reimbursement> reimbursementList = new ArrayList<>();

        //Create connection and perform select query
        try{
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "SELECT * from reimbursement where author_id = ?");
            ps.setInt(1, id);

            //Get results from query and construct Reimbursement list
            ResultSet queryResult = ps.executeQuery();
            while(queryResult.next()){

                Integer reID = queryResult.getInt("reimbursement_id");
                float amount = queryResult.getFloat("reimbursement_amount");
                String timesubmitted = queryResult.getString("time_submitted");
                String timeresolved = queryResult.getString("time_resolved");
                String description = queryResult.getString("description");
                byte[] reciept = queryResult.getBytes("reciept");
                Integer authorID = queryResult.getInt("author_id");
                Integer resolverID = queryResult.getInt("resolver_id");
                Integer statusID = queryResult.getInt("status_id");
                Integer typeID = queryResult.getInt("type_id");

                //create new reimbursement and add to the reimbursement list
                Reimbursement reimbursement = new Reimbursement(reID ,amount, timesubmitted,timeresolved,description,
                        reciept,authorID,resolverID,statusID, typeID);
                reimbursementList.add(reimbursement);
            }


        }catch(SQLException e){
            e.printStackTrace();
            reimbursementLog.debug("Select All Reimbursements by Author ID failed!!!");

        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> select_All_Reimbursement_By_Status_ID(int status_ID) {
        List<Reimbursement> reimbursementList = new ArrayList<>();

        //Create connection and perform select query
        try{
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "SELECT * from reimbursement where status_id = ?");
            ps.setInt(1, status_ID);

            //Get results from query and construct Reimbursement list
            ResultSet queryResult = ps.executeQuery();
            while(queryResult.next()){

                Integer reID = queryResult.getInt("reimbursement_id");
                float amount = queryResult.getFloat("reimbursement_amount");
                String timesubmitted = queryResult.getString("time_submitted");
                String timeresolved = queryResult.getString("time_resolved");
                String description = queryResult.getString("description");
                byte[] reciept = queryResult.getBytes("reciept");
                Integer authorID = queryResult.getInt("author_id");
                Integer resolverID = queryResult.getInt("resolver_id");
                Integer statusID = queryResult.getInt("status_id");
                Integer typeID = queryResult.getInt("type_id");

                //create new reimbursement and add to the reimbursement list
                Reimbursement reimbursement = new Reimbursement(reID ,amount, timesubmitted,timeresolved,description,
                        reciept,authorID,resolverID,statusID, typeID);
                reimbursementList.add(reimbursement);
            }


        }catch(SQLException e){
            e.printStackTrace();
            reimbursementLog.debug("Select All Reimbursements by Status ID failed!!!");

        }
        return reimbursementList;


    }

    @Override
    public Reimbursement select_Reimbursement_By_ID(Integer id) {
        Reimbursement reimbursement = null;

        //Get DB connection and execute prepared statement
        try{
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "SELECT reimbursement_amount, time_submitted, time_resolved, description, reciept, author_id, resolver_id, status_id, type_id from reimbursement where reimbursement_id = ?");
            ps.setInt(1,id);
            ResultSet queryResult = ps.executeQuery();

            //Increment result set row and get data
            queryResult.next();
                float amount = queryResult.getFloat("reimbursement_amount");
                String timesubmitted = queryResult.getString("time_submitted");
                String timeresolved = queryResult.getString("time_resolved");
                String description = queryResult.getString("description");
                byte[] reciept = queryResult.getBytes("reciept");
                Integer authorID = queryResult.getInt("author_id");
                Integer resolverID = queryResult.getInt("resolver_id");
                Integer statusID = queryResult.getInt("status_id");
                Integer typeID = queryResult.getInt("type_id");

                //Construct reimbursement and return it
                reimbursement = new Reimbursement( id,amount, timesubmitted,timeresolved,description,
                        reciept,authorID,resolverID,statusID, typeID);
                return reimbursement;

        }catch(SQLException e){
            e.printStackTrace();
            reimbursementLog.debug("Select Reimbursement By ID Failure!");

        }

        return reimbursement;

    }

    @Override
    public boolean insert(Reimbursement reimbursement) {

        boolean updated = false;

        try {
            Connection myConnect = DB_Connector.getConnection();
            PreparedStatement ps = myConnect.prepareStatement(
                    "INSERT into reimbursement (reimbursement_Amount, time_Submitted," +
                            " time_Resolved, description, reciept, author_ID, status_ID, type_ID) values (?,?,?,?,?,?,?,?)");

            ps.setFloat(1, reimbursement.getReimbursement_Amount());
            ps.setString(2, reimbursement.getTime_Submitted());
            ps.setString(3, reimbursement.getTime_Resolved());
            ps.setString(4, reimbursement.getDescription());
            ps.setBytes(5, reimbursement.getReciept());
            ps.setInt(6, reimbursement.getAuthor_ID());
            ps.setInt(7, reimbursement.getStatus_ID());
            ps.setInt(8, reimbursement.getType_ID());
            ps.execute();
            updated = true;

        } catch (SQLException e) {
            e.printStackTrace();
            reimbursementLog.debug("Reimbursement insert failed");
        }
        return updated;
    }

    @Override
    public boolean update(Reimbursement reimbursement) {

            try{
                Connection myConnect = DB_Connector.getConnection();
                PreparedStatement ps = myConnect.prepareStatement(
                        "UPDATE reimbursement set reimbursement_amount = ?, " +
                                "time_submitted = ?, time_resolved = ?," +
                                " description = ?, reciept = ?, author_id = ?," +
                                " resolver_id = ?, status_id = ?, type_id = ?" +
                                "where reimbursement_id = ?");

                ps.setFloat(1, reimbursement.getReimbursement_Amount());
                ps.setString(2, reimbursement.getTime_Submitted());
                ps.setString(3, reimbursement.getTime_Resolved());
                ps.setString(4, reimbursement.getDescription());
                ps.setBytes(5, reimbursement.getReciept());
                ps.setInt(6, reimbursement.getAuthor_ID());
                ps.setInt(7, reimbursement.getResolver_ID());
                ps.setInt(8, reimbursement.getStatus_ID());
                ps.setInt(9, reimbursement.getType_ID());
                ps.setInt(10, reimbursement.getReimbursement_ID());
                ps.execute();

                return true;

            }catch(SQLException e){
                e.printStackTrace();
                reimbursementLog.debug("Update Reimbursement Failure!");
            }

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
