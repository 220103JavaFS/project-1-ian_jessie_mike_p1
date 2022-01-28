package com.revature.controller;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.utils.Encryptor;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Login_Controller extends Controller{

    private final LoginService loginService= new LoginService();
    private final Encryptor encryptor = new Encryptor();
    private final Users_DAO_IMP userdao = new Users_DAO_IMP();
    private static final Logger loginControllerLog = LoggerFactory.getLogger(LoginService.class);


    private Handler register = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);
        user.setUser_Pass(encryptor.encoder(user.getUser_Pass()));
        if(userdao.insert(user)){
            loginControllerLog.info("New User Registered!!!");
            ctx.json(user);
            ctx.status(201);
        }else{
            loginControllerLog.info("New User Registration Failed!!!");
            ctx.status(400);
        }
    };

    private Handler login = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);
        if (loginService.userLogin(user.getUser_Name(),user.getUser_Pass())) {
            loginControllerLog.info("New User Logged in!!!");
            ctx.req.getSession();
            //Something with user validation.
            ctx.status(200);
        } else {
            ctx.req.getSession().invalidate();
            loginControllerLog.info("User Login Failed!!!");
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
       app.post("/login", login);
       app.post("/register", register);

    }
}
