package com.java.ro.ptng.ch6;

import com.java.ro.ptng.ch5.User;
import org.fest.assertions.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Bartek on 2015-02-25.
 */
public class UserListTest {

    public static final User USER1 = new User();
    public static final User USER2 = new User();
    private UserList userList;

    @BeforeMethod
    public void setup() {
        userList = new UserList();
    }

    @Test
    public void emptyListIsReturnedWhenNoUserAdded() {
        assertThat(userList.getUsers()).isNotNull().isEmpty();
    }

    @Test
    public void oneEntryListIsReturnedWhenOneUserAdded() {
        userList.addUser(USER1);
        assertThat(userList.getUsers()).isNotNull().containsExactly(USER1);
    }

    @Test
    public void twoEntryListIsReturnedWhenTwoUsersAdded() {
        userList.addUser(USER1);
        userList.addUser(USER2);
        assertThat(userList.getUsers()).isNotNull().containsExactly(USER1, USER2);
    }
}
