package com.revature.controller;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.service.LoginService;
import com.revature.service.UserRoleService;
import com.revature.service.UserService;
import com.revature.utils.Encryptor;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Registration_Controller extends Controller{

    private final Encryptor encryptor = new Encryptor();
    private final UserService userService = new UserService();
    private final UserRoleService userRoleService = new UserRoleService();
    private static final Logger RegistrationControllerLog = LoggerFactory.getLogger(Registration_Controller.class);


    private Handler register = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);
        user.setUser_Pass(encryptor.encoder(user.getUser_Pass()));
        if(userService.insertUser(user)){
            RegistrationControllerLog.info("New User Registered!!!");

            //create session for newly registered user
            String role = userRoleService.SelectUserRoleByRoleID(user.getUser_Role_ID());
            ctx.req.getSession();
            ctx.req.getSession().setAttribute("user_role",role);
            ctx.req.getSession().setAttribute("user_id", ""+user.getUser_ID());

            //check whether user is employee or manager and redirect them to their respective homepage
            if(role.equals("employee")){
                ctx.redirect("/employee/"+user.getUser_ID(), 200);
            }else{
                //route not built yet
                ctx.redirect("/manager/"+user.getUser_ID(), 200);
            }
        }else{
            RegistrationControllerLog.info("New User Registration Failed!!!");
            ctx.status(400);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/register", register);

    }

}
