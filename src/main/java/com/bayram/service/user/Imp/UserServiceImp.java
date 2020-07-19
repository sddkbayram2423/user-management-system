package com.bayram.service.user.Imp;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bayram.dao.user.UserRepository;
import com.bayram.exception.UserAlreadyExistException;
import com.bayram.model.user.Role;
import com.bayram.model.user.User;
import com.bayram.service.user.RoleService;
import com.bayram.service.user.UserService;
import com.bayram.web.dto.UserDto;
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		return userRepository.saveUser(user);
	}

	@Override
	public User deleteUser(User user) {
		return userRepository.deleteUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public User findUserById(long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User findUserByUserName(String name) {
			return userRepository.findUserByUserName(name);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
	
	
	@Override
	public User registerNewUser(UserDto userDto) {
		
		boolean status=isUserNameExist(userDto.getUsername());
		
		if(status) {
			throw new UserAlreadyExistException(userDto.getUsername()+" username already is exist");
		}
		
		Role role=roleService.findRoleByName("USER");
		
		User user=new User();
		user.setFistname(userDto.getFistname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRole(role);	
		
		
		
		
		return userRepository.saveUser(user);
	}
	
	@Override
	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		
		return passwordEncoder.matches(oldPassword.trim(), user.getPassword().trim());
	}

	@Override
	public void changeForgotUserPassword(User user, String password) {
		user.setPassword(passwordEncoder.encode(password));
		userRepository.updateUser(user);
		
	}
	private boolean isUserNameExist(String userName) {
		return findUserByUserName(userName)!=null;
	}

	@Override
	public void resetPassword(String oldPassword, String newPassord, long id) {
		
		User user=userRepository.findUserById(id);
		
		if(checkIfValidOldPassword(user, oldPassword)) {
			user.setPassword(passwordEncoder.encode(newPassord));
			userRepository.updateUser(user);
		}
		
	}

	
}
