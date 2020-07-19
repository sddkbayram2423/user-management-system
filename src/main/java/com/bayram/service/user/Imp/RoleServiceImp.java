package com.bayram.service.user.Imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.user.RoleRepository;
import com.bayram.model.user.Role;
import com.bayram.service.user.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleRepository  roleRepository;
	
	@Override
	public Role saveRole(Role role) {
		return roleRepository.saveRole(role);
	}

	@Override
	public Role deleteRole(Role role) {
		return roleRepository.deleteRole(role);
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepository.updateRole(role);
	}

	@Override
	public Role findRoleById(long id) {
		return roleRepository.findRoleById(id);
	}

	@Override
	public Role findRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}

	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAllRoles();
	}

}
