package com.cargo.service;

import com.cargo.model.Role;
import com.cargo.model.User;

public interface UserService {

    User create(String username, String password, Role role);

}