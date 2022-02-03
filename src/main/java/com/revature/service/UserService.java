package com.revature.service;

import com.revature.dao.IUsers_DAO;
import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    private final Integer EMPLOYEE_ROLE = 1;
    private final Integer MANAGER_ROLE = 2;
    private final Integer MINIMUM_NAME_LENGTH = 2;
    private final Integer MAXIMUM_NAME_LENGTH = 25;
    private final Integer MINIMUM_PASSWORD_LENGTH = 8;
    private final Integer MAXIMUM_PASSWORD_LENGTH = 100;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static IUsers_DAO users_dao;

    public UserService(IUsers_DAO users_dao){UserService.users_dao = users_dao;};
    public UserService(){users_dao = new Users_DAO_IMP();}

    public Users selectUserByUsername(String username){return users_dao.selectUserByUsername(username);}

    public Users selectUserByID(int id){return users_dao.selectUserByID(id);}

    public boolean insertUser(Users users){
        if(validateEmail(users.getUser_Email()) &&
                users.getUser_Name().length() >= MINIMUM_NAME_LENGTH &&
                users.getUser_Pass().length() >= MINIMUM_PASSWORD_LENGTH &&
                users.getUser_Name().length() <= MAXIMUM_NAME_LENGTH &&
                users.getUser_Pass().length() <= MAXIMUM_PASSWORD_LENGTH &&
                (users.getUser_Role_ID() == EMPLOYEE_ROLE || users.getUser_Role_ID() == MANAGER_ROLE)){
            return users_dao.insert(users);
        }
        return false;
    }

    public boolean updateUser(Users users) {
        if (validateEmail(users.getUser_Email()) &&
                users.getUser_Name().length() >= MINIMUM_NAME_LENGTH &&
                users.getUser_Pass().length() >= MINIMUM_PASSWORD_LENGTH &&
                users.getUser_Name().length() <= MAXIMUM_NAME_LENGTH &&
                users.getUser_Pass().length() <= MAXIMUM_PASSWORD_LENGTH &&
                (users.getUser_Role_ID() == EMPLOYEE_ROLE || users.getUser_Role_ID() == MANAGER_ROLE)) {
            return users_dao.update(users);
        }
        return false;
    }
}
