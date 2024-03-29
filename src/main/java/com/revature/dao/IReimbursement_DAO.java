package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

import java.util.List;

public interface IReimbursement_DAO {

    //view all reimbursements
    List<Reimbursement> select_All_Reimbursements();


    //Admin view of all single users reimbursements
    List<Reimbursement> select_All_Reimbursements_By_Author_ID(Integer id);

    //Filter by status
    List<Reimbursement> select_All_Reimbursement_By_Status_ID(int status_ID);

    Reimbursement select_Reimbursement_By_ID(Integer id);

    List<Reimbursement> select_All_Pending_Reimbursements();

    //Add reimbursement request
    boolean insert(Reimbursement reimbursement);

    //approve deny reimbursement requests
    boolean update(Reimbursement reimbursement);

   // boolean delete(Reimbursement reimbursement);

    //List<Reimbursement> select_Reimbursement_By_Author(Users users);

    //List<Reimbursement> select_Reimbursement_By_Resolver(Users users);
}
