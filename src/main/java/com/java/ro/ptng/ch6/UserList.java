package com.java.ro.ptng.ch6;

import com.java.ro.ptng.ch5.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2015-02-25.
 */
public class UserList {

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
