package com.revature.controller;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.service.LoginService;
import com.revature.service.UserService;
import com.revature.utils.Encryptor;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Registration_Controller extends Controller{

    private final Encryptor encryptor = new Encryptor();
    private final Users_DAO_IMP userdao = new Users_DAO_IMP();
    private static final Logger loginControllerLog = LoggerFactory.getLogger(LoginService.class);


    private Handler register = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);
        user.setUser_Pass(encryptor.encoder(user.getUser_Pass()));
        if(userdao.insert(user)){
            loginControllerLog.info("New User Registered!!!");
            ctx.json(user);
            ctx.status(200);


            /*code for redirect after registration, will implement once
            * front-end and back-end are linked*/

 //           if(user.getUser_Role_ID() == 1)
 //               ctx.redirect("/employeeHome",200);
 //           else
 //               ctx.redirect("/managerHome", 200);
        }else{
            loginControllerLog.info("New User Registration Failed!!!");
            ctx.status(400);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/register", register);

    }

}
