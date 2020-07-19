package com.bayram.service.user;

import java.util.List;

import com.bayram.model.user.Role;



public interface RoleService {
	
	public Role saveRole(Role role);

	public Role deleteRole(Role role);

	public Role updateRole(Role role);
	
	public Role findRoleById(long id);
	
	public Role findRoleByName(String name);

	public List<Role> findAllRoles();

}
