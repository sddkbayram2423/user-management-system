package com.bayram.dao.user;

import java.util.List;

import com.bayram.model.user.Privilige;

public interface PriviligeRepository {
	
	Privilige savePrivilige(Privilige privilige);

	Privilige deletePrivilige(Privilige privilige);

	Privilige updatePrivilige(Privilige privilige);

	Privilige findPriviligeById(long id);
	
	Privilige findPriviligeByName(String name);

	List<Privilige> findAllPriviliges();

	

}
