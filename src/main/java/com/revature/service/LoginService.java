package com.revature.service;

import com.revature.dao.IUsers_DAO;
import com.revature.dao.Reimbursement_DAO_IMP;
import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.utils.Encryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

public class LoginService {

    private static Encryptor encryptor;
    private static IUsers_DAO user;
    private static final Logger loginLog = LoggerFactory.getLogger(LoginService.class);

    public LoginService(IUsers_DAO user) {
        LoginService.user = user; encryptor= new Encryptor();}

    public LoginService(){encryptor = new Encryptor(); user = new Users_DAO_IMP();}

    public boolean userLogin(String username, String password) throws NoSuchAlgorithmException {
        //Retrieve user attempting to log in
        Users secureUser = user.selectUserByUsername(username);

        //If User exists proceed, else return false and log incident
        if(secureUser != null){
            String passCheck = encryptor.encoder(password);
            String securePassword = secureUser.getUser_Pass();
            //Check current hash against DB hash
            if(securePassword.equals(passCheck)){
                loginLog.info("User " + secureUser.getUser_Name() + " has logged in successfully!");
                return true;
            }else {
                loginLog.info("User " + secureUser.getUser_Name() + " login has failed!");
                return false;
            }
        }else{
            loginLog.info("User with no credentials attempted login");
            return false;
        }
    }
}

