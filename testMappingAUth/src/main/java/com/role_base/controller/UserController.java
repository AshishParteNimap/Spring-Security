package com.role_base.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role_base.model.Role;
import com.role_base.model.User;
import com.role_base.repo.CRepo;
import com.role_base.repo.Srepo;
import com.role_base.serviceImpl.IUser;

@RestController
//@CrossOrigin("http://localhost:8080")
@RequestMapping("/User")
public class UserController {

	@Autowired
	private IUser Simpl;
	
	@Autowired
	private Srepo srepo;
	
	@Autowired
	private CRepo repo;
	
	@Autowired
	private PasswordEncoder pass;
	
	
	@GetMapping("/all")
	public List<User> getAll(){
		return Simpl.getAll();
		
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return Simpl.getById(id);
	}
	
	@PreAuthorize("hasAuthority('ADD') or hasRole('ADMIN')")
	@PostMapping("/add")
	
	public String addUser(@RequestBody User user) {
		String password=user.getPassword();
		String encrypt=pass.encode(password);
		user.setPassword(encrypt);
		user.setRoles(new HashSet<>(repo.findAll()));
		Simpl.addUser(user);
		return "studnet Added";
	}
	
	@DeleteMapping("/{id}")
	public String removeUser(@PathVariable Long id) {
		Simpl.deleteUser(id);
		return "deleted";
	}
	
}
