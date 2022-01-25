package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

import java.util.ArrayList;
import java.util.List;

public class Reimbursement_DAO_IMP implements IReimbursement_DAO{


    @Override
    public List<Reimbursement> select_All_Reimbursements() {
        List<Reimbursement> reimbursements = new ArrayList<>();

        return reimbursements;
    }

    @Override
    public List<Reimbursement> select_Reimbursement_By_Author(Users users) {
        return null;
    }

    @Override
    public List<Reimbursement> select_Reimbursement_By_Resolver(Users users) {
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
        return false;
    }

    @Override
    public boolean update(Reimbursement reimbursement) {
        return false;
    }

    @Override
    public boolean delete(Reimbursement reimbursement) {
        return false;
    }
}
