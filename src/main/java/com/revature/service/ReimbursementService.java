package com.revature.service;

import com.revature.dao.IReimbursement_DAO;
import com.revature.dao.Reimbursement_DAO_IMP;
import com.revature.models.Reimbursement;

import java.util.List;

public class ReimbursementService {

    private final IReimbursement_DAO serviceReimbursement;

    public ReimbursementService(){serviceReimbursement = new Reimbursement_DAO_IMP();}

    public boolean insertReimbursement(Reimbursement newReimbursement){return serviceReimbursement.insert(newReimbursement);}

    public boolean updateReimbursement(Reimbursement newReimbursement){return serviceReimbursement.update(newReimbursement);}

    public Reimbursement selectReimbursementByID(Integer id){return serviceReimbursement.select_Reimbursement_By_ID(id);}

    public List<Reimbursement> selectAllReimbursements(){return serviceReimbursement.select_All_Reimbursements();}

    public List<Reimbursement> selectAllReimbursementsByAuthorID(Integer id){return serviceReimbursement.select_All_Reimbursements_By_Author_ID(id);}

    public List<Reimbursement> selectAllReimbursementByStatusID(Integer id){return serviceReimbursement.select_All_Reimbursement_By_Status_ID(id);}

}
