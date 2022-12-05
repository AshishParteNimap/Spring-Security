package com.role_base.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.role_base.model.Permission;
import com.role_base.model.Role;
import com.role_base.repo.CRepo;
import com.role_base.repo.PermissionRepo;
import com.role_base.service.CourseSrvc;

@Service

public class IRole implements CourseSrvc{

	@Autowired
	private CRepo Crpo;
	
	@Autowired
	private PermissionRepo Prepo;
	
	@Override
	public List<Role> getAllRoles() {
		return Crpo.findAll();
	}
	
	public Role getRoleById(Long RoleId) {
		return  Crpo.findById(RoleId).orElse(null);
		
		
	}
	

	@Override
	public Role getById(Long id) {
		
		return Crpo.findById(id).orElse(null);
	}

	@Override
	public String addRole(Role role) {
		Crpo.save(role);
		return "added";
	}



	@Override
	public String deleteRole(Long id) {
		Crpo.deleteById(id);
		return "deleted";
	}

	

	@Override
	public String addPermission(Permission permission) {
		Prepo.save(permission);
		return "added";
	}

	@Override
	public String deletePermission(Long id) {
		Prepo.deleteById(id);
		return "deleted";
		
	}

	@Override
	public List<Permission> getAll() {
		 //TODO Auto-generated method stub
		return Prepo.findAll();
	}

	

}
