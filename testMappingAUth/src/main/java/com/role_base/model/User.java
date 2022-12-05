package com.role_base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter@Setter
//@AllArgsConstructor
//@NoArgsConstructor

@Table(name = "User")
@Transactional
public class User {
	@Id
	@GeneratedValue
	
	private Long id;
	private String username;
	private String Password;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "User_Role",joinColumns = @JoinColumn(name="U_id"),
	inverseJoinColumns = @JoinColumn(name="R_id"))
	private Set<Role> roles=new HashSet<>();

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", Password=" + Password + ", roles=" + roles + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	


	
	

}
