package com.juice.login.service;

import com.juice.login.entity.User;

public interface UserService {
	 User findUserByUserAccount(String userAccount);
	 void saveUser(User user, String role);
}
