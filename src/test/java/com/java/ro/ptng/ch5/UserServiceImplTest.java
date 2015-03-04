package com.java.ro.ptng.ch5;


import com.googlecode.catchexception.CatchException;
import org.fest.assertions.Assertions;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static com.googlecode.catchexception.CatchException.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    public static final String PASSWORD = "somePassword";
    public static final String PASSWORD_MD5 = "somePasswordMd5";
    public static final String EXCETION_MESSAGE = "Some md5 exception message.";

    private UserServiceImpl userService;
    private UserDAO userDAO;
    private SecurityService securityService;

    @BeforeMethod
    public void setup() {
        userDAO = mock(UserDAO.class);
        securityService = mock(SecurityService.class);
        userService = new UserServiceImpl(userDAO, securityService);
    }

    @Test
    public void assignPasswordShouldSaveNewPasswordAndUser() throws Exception {
        User user = new User();
        user.setPassword(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(PASSWORD_MD5);

        userService.assignPassword(user);

        Assert.assertEquals(user.getPassword(), PASSWORD_MD5);
        verify(userDAO).updateUser(user);
    }

    @Test(expectedExceptions = SQLException.class)
    public void assignPasswordShouldThrowExceptionIfSaveThrownException() throws Exception {
        User user = new User();
        user.setPassword(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(PASSWORD_MD5);
        doThrow(SQLException.class).when(userDAO).updateUser(user);

        userService.assignPassword(user);
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = ".*md5 exception.*")
    public void assignPasswordShouldThrowExceptionWhenMd5ThrowsException() throws Exception {
        User user = new User();
        user.setPassword(PASSWORD);
        when(securityService.md5(PASSWORD)).thenThrow(new RuntimeException("Some md5 exception message."));

        userService.assignPassword(user);
    }

    @Test
    public void assignPasswordShouldThrowExceptionWhenMd5ThrowsException2() throws Exception {
        User user = new User();
        user.setPassword(PASSWORD);
        when(securityService.md5(PASSWORD)).thenThrow(new RuntimeException("Some md5 exception message."));

        catchException(userService).assignPassword(user);
        Exception exception = caughtException();

        Assertions.assertThat(exception).isInstanceOf(RuntimeException.class).hasMessage(EXCETION_MESSAGE);
        verify(userDAO, never()).updateUser(user);
    }

}