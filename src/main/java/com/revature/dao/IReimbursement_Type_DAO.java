package com.revature.dao;

import com.revature.models.Reimbursement_Type;

import java.util.List;

public interface IReimbursement_Type_DAO {

    Reimbursement_Type selectReimbursementTypeByID(int id);

    List<Reimbursement_Type> selectAllReimbursementType();

    boolean insertReimbursementType(Reimbursement_Type reimbursement_type);

    boolean updateReimbursementType(Reimbursement_Type reimbursement_type);

}
