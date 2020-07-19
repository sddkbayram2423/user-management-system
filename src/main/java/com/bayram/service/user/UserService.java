package com.bayram.service.user;

import java.util.List;

import com.bayram.model.user.User;
import com.bayram.web.dto.UserDto;


public interface UserService {
	
	User registerNewUser(UserDto userDto);

	boolean checkIfValidOldPassword(User user, String oldPassword);

	void changeForgotUserPassword(User user, String password);
	
	User saveUser(User user);

	User deleteUser(User user);

	User updateUser(User user);

	User findUserById(long id);
	
	User findUserByUserName(String name);

	User findUserByEmail(String email);

	List<User> findAllUsers();
	
	void resetPassword(String oldPassword,String newPassord,long id);
	
	
	
}
