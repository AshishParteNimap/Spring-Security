package com.role_base.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;


import com.role_base.model.Permission;
import com.role_base.model.Role;


public interface CourseSrvc {

	public List<Role> getAllRoles();
	
	public Role getById(Long id);
	
	public String addRole(@RequestBody Role role);
	
	
    public String deleteRole(Long id);
    
    public List<Permission> getAll();
    
    
    public String addPermission(Permission permission);
    
    public String deletePermission(Long id);
	
}
