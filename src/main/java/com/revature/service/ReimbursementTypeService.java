package com.revature.service;

import com.revature.dao.IReimbursement_Status_DAO;
import com.revature.dao.IReimbursement_Type_DAO;
import com.revature.dao.Reimbursement_Type_DAO_IMP;

public class ReimbursementTypeService {

    private static IReimbursement_Type_DAO reimbursement_type_dao;

    ReimbursementTypeService(IReimbursement_Type_DAO reimbursement_type_dao){
        ReimbursementTypeService.reimbursement_type_dao = reimbursement_type_dao;
    }

    public ReimbursementTypeService(){reimbursement_type_dao = new Reimbursement_Type_DAO_IMP();}

    public String selectReimbursementTypeByID(int id){ return reimbursement_type_dao.selectReimbursementTypeByID(id);}
}
