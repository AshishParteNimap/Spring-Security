package com.role_base.UserDetails;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.role_base.model.Role;
import com.role_base.model.User;

import lombok.Value;

@Component

public class CustomeUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	
	
	public CustomeUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomeUser(User user) {
		super();
		this.user = user;
	}
	
	@Override
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles=user.getRoles();
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		//Collection<GrantedAuthority> authorities=new ArrayList<>(roles.size());
		for(Role role1:roles) {
			//authorities.addAll(user.getRoles().stream().map(a->new SimpleGrantedAuthority(a.getRole())).collect(Collectors.toList()));
			
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role1.getRole()));
		}
		
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
		}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
