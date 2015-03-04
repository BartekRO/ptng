package com.java.ro.ptng.ch5;

/**
 * Created by Bartek on 2015-02-24.
 */
public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}
