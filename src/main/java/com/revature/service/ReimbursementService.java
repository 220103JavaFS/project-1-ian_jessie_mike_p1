package com.revature.service;

import com.revature.dao.IReimbursement_DAO;
import com.revature.dao.Reimbursement_DAO_IMP;
import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Reimbursement;

import java.util.List;

public class ReimbursementService {

    private final Integer MINIMUM_REIMBURSEMENT_AMOUNT = 0;
    private final Integer MINIMUM_DESCRIPTION_LENGTH = 3;



    private static IReimbursement_DAO serviceReimbursement;

    public ReimbursementService(IReimbursement_DAO serviceReimbursement){ReimbursementService.serviceReimbursement = serviceReimbursement;}

    public ReimbursementService(){serviceReimbursement = new Reimbursement_DAO_IMP();}

    public boolean insertReimbursement(Reimbursement newReimbursement){
        if (newReimbursement.getReimbursement_Amount() > MINIMUM_REIMBURSEMENT_AMOUNT &&
                newReimbursement.getDescription().length() >= MINIMUM_DESCRIPTION_LENGTH){
            return serviceReimbursement.insert(newReimbursement);
        }else{
            return false;
        }
    }

    public boolean updateReimbursement(Reimbursement newReimbursement){
        if (newReimbursement.getReimbursement_Amount() > MINIMUM_REIMBURSEMENT_AMOUNT &&
                newReimbursement.getDescription().length() >= MINIMUM_DESCRIPTION_LENGTH){
            return serviceReimbursement.insert(newReimbursement);
        }else{
            return false;
        }
    }

    public Reimbursement selectReimbursementByID(Integer id){return serviceReimbursement.select_Reimbursement_By_ID(id);}

    public List<Reimbursement> selectAllReimbursements(){return serviceReimbursement.select_All_Reimbursements();}

    public List<Reimbursement> selectAllReimbursementsByAuthorID(Integer id){return serviceReimbursement.select_All_Reimbursements_By_Author_ID(id);}

    public List<Reimbursement> selectAllReimbursementByStatusID(Integer id){return serviceReimbursement.select_All_Reimbursement_By_Status_ID(id);}

    public List<Reimbursement> selectAllPendingReimbursements(){return serviceReimbursement.select_All_Pending_Reimbursements();}

}
