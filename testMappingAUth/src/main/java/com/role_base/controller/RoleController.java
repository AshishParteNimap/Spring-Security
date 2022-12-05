package com.role_base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role_base.model.Role;
import com.role_base.model.Permission;
import com.role_base.serviceImpl.IRole;

@RestController
@RequestMapping("/crs")
public class RoleController {

	@Autowired
	private IRole crsI;
	
	@GetMapping("/all")
	public List<Role> getAll(){
		return crsI.getAllRoles();
	}
	@PostMapping("/add")
	public String addRole(@RequestBody Role crs) {
		crsI.addRole(crs);
		return "added";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCource(@PathVariable Long id) {
		crsI.deleteRole(id);
		return "deleted successful";
	}
	
	@PostMapping("/addP")
	public String addPermission(@RequestBody Permission permission) {
		crsI.addPermission(permission);
		return "added permission";
	}
	
	@PreAuthorize("hasAuthority('ADD') or hasRole('USER')")
	@GetMapping("/allP")
	public List<Permission> getAllPermission(){
		return crsI.getAll();
	}
}
