package com.bayram.dao.user;

import java.util.List;


import com.bayram.model.user.User;

public interface UserRepository {
	
	User saveUser(User user);

	User deleteUser(User user);

	User updateUser(User user);

	User findUserById(long id);
	
	User findUserByUserName(String name);

	User findUserByEmail(String email);

	List<User> findAllUsers();
	
	void updatePassword(String password,long id);


}
