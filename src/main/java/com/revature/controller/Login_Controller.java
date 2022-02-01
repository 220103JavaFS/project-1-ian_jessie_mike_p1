package com.revature.controller;

import com.revature.models.Users;
import com.revature.service.UserRoleService;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import com.revature.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Login_Controller extends Controller{

    private final UserService userService = new UserService();
    private final LoginService loginService= new LoginService();
    private final UserRoleService userRoleService = new UserRoleService();
    private static final Logger loginControllerLog = LoggerFactory.getLogger(Login_Controller.class);


    private Handler login = ctx -> {
        Users user = ctx.bodyAsClass(Users.class);

        //check if users credentials are valid
        if (loginService.userLogin(user.getUser_Name(),user.getUser_Pass())) {
            loginControllerLog.info("New User Logged in!!!");

            //Storing user role in httpSession data for route protection
            Users loguser = userService.selectUserByUsername(user.getUser_Name());
            String role = userRoleService.SelectUserRoleByRoleID(loguser.getUser_Role_ID());
            ctx.req.getSession();
            ctx.req.getSession().setAttribute("user_role",role);
            ctx.req.getSession().setAttribute("user_id", loguser.getUser_ID());
            ctx.req.getSession().setAttribute("user_role_id", loguser.getUser_Role_ID());
            //get role ID so it is return in response for JS verification
            Integer roleID = (Integer) ctx.req.getSession().getAttribute("user_role_id");



            //check whether user is employee or manager and redirect them to their respective homepage
            if(role.equals("employee")){
                ctx.json(roleID);
                ctx.redirect("/employee/"+loguser.getUser_ID(), 200);

            }else{
                //route not built yet
                ctx.json(roleID);
                ctx.redirect("/manager/"+loguser.getUser_ID(), 200);
            }
            //else credentials are invalid log incident and inform user
        } else {
            ctx.req.getSession().invalidate();
            ctx.json("Username or password incorrect!!!");
            loginControllerLog.info("User Login Failed!!!");
            ctx.status(404);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
       app.post("/login", login);
    }
}
