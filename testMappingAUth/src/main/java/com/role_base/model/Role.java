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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Roles")
@Transactional
public class Role {
@Id
@GeneratedValue
private Long id;
private String Role;


@JsonIgnore
@ManyToMany(mappedBy = "roles")
private Set<User> user=new HashSet<>();

@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
@JoinTable(name="Role_Permission",
joinColumns =  @JoinColumn(name="Role_id"),
inverseJoinColumns = @JoinColumn(name="permission_id"))
private Set<Permission> permissions=new HashSet<>();


}
