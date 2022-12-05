package com.role_base.model;

import java.io.Serializable;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.role_base.service.CourseSrvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Permissions")
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String Permission;

	
	
// @ManyToMany(mappedBy = "permissions")
// private Set<Role> roles;
//	
//	@ManyToOne
//	@JoinTable(name = "Course_Permission",
//	joinColumns = @JoinColumn(name="permission_id"),
//	inverseJoinColumns = @JoinColumn(name="course_id"))
//	private Role role;
	
	
}
