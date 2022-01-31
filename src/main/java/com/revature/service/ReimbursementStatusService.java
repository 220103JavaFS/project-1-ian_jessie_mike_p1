package com.revature.service;

import com.revature.dao.IReimbursement_Status_DAO;
import com.revature.dao.Reimbursement_Status_DAO_IMP;

public class ReimbursementStatusService {
    private final IReimbursement_Status_DAO reimbursement_status_dao;

    public ReimbursementStatusService(){reimbursement_status_dao = new Reimbursement_Status_DAO_IMP();}

    public String selectReimbursementStatusByID(int id){return reimbursement_status_dao.selectReimbursementStatusByID(id);}

}
