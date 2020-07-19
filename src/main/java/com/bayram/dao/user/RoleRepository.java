package com.bayram.dao.user;

import java.util.List;

import com.bayram.model.user.Role;

public interface RoleRepository {
	
	Role saveRole(Role role);

	Role deleteRole(Role role);

	Role updateRole(Role role);
	
	Role findRoleById(long id);
	
	Role findRoleByName(String name);

	List<Role> findAllRoles();



}
