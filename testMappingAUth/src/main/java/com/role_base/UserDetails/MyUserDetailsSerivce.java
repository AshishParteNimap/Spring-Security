package com.role_base.UserDetails;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.role_base.model.Permission;
import com.role_base.model.User;
import com.role_base.repo.Srepo;

@Service
public class MyUserDetailsSerivce implements UserDetailsService{

	@Autowired
	private Srepo repo;
    
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUsername(username).orElse(null);
		if(username==null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println(user);
		System.out.println(user.getRoles());
		Set<GrantedAuthority> ga=new HashSet<>();
		for(com.role_base.model.Role role:user.getRoles()) {
			ga.add(new SimpleGrantedAuthority(role.getRole()));
		
		
		
		for(Permission permission:role.getPermissions()) {
			ga.add(new SimpleGrantedAuthority(permission.getPermission()));
			
		}
		}
		
		
	 System.out.println(ga);
		return new CustomeUser(user);
	}

}
