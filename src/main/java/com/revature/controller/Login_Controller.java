package com.revature.controller;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.service.UserService;
import com.revature.utils.Encryptor;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Login_Controller extends Controller{

    private final LoginService loginService= new LoginService();
//    private final UserService userService = new UserService();
    private static final Logger loginControllerLog = LoggerFactory.getLogger(LoginService.class);


    private Handler login = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);
        if (loginService.userLogin(user.getUser_Name(),user.getUser_Pass())) {
            loginControllerLog.info("New User Logged in!!!");
            ctx.req.getSession();
            ctx.status(200);

            /*
            Code for storing user role in httpSession data for route protection
            Users loginUser = userService.selectUserByUsername(user.getUser_Name());
            ctx.req.getSession();
            ctx.req.getSession().setAttribute("user_role",loginUser.getUser_Role_ID());
            ctx.status(200);*/
        } else {
            ctx.req.getSession().invalidate();
            ctx.json("Username or password incorrect!!!");
            loginControllerLog.info("User Login Failed!!!");
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
       app.post("/login", login);
    }
}
