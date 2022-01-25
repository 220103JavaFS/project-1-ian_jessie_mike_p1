package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

import java.util.List;

public interface IReimbursement_DAO {

    List<Reimbursement> select_All_Reimbursements();

    List<Reimbursement> select_Reimbursement_By_Author(Users users);

    List<Reimbursement> select_Reimbursement_By_Resolver(Users users);

    List<Reimbursement> select_Reimbursement_By_Status_ID(int status_ID);

    Reimbursement select_Reimbursement_By_ID(int id);

    boolean insert(Reimbursement reimbursement);

    boolean update(Reimbursement reimbursement);

    boolean delete(Reimbursement reimbursement);

}
