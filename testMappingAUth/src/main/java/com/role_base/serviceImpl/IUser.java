package com.role_base.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.role_base.UserDetails.CustomeUser;
import com.role_base.model.Role;
import com.role_base.model.User;
import com.role_base.repo.CRepo;
import com.role_base.repo.Srepo;
import com.role_base.service.UserSrvc;

@Service
public class IUser implements UserSrvc {

	@Autowired
	private Srepo repo;
	
	@Autowired 
	private CRepo Crepo;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getById(Long User_id) {
		return repo.findById(User_id).orElse(null);
		
	}

	@Override
	public String addUser(User User) {
		
//		Course crs=new Course();
//		User.setUserName(User.getUserName());
//		User.setDepartment(User.getDepartment());
//		User.setCourse(User.getCourse());
//		User.setId(User.getId());
		repo.save(User);
		return "User added";
	}

	@Override
	public String deleteUser(Long id) {
		User User=repo.findById(id).orElse(null);
		repo.delete(User);
		return "deleted";
	}

	@Override
	public User assignCourse(Long User_id, Long Course_Id) {
		Set<Role> usr=null;
		User User=repo.findById(User_id).get();
		Role role=Crepo.findById(Course_Id).get();
		usr=User.getRoles();
		usr.add(role);
		User.setRoles(usr);
		return repo.save(User);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUsername(username).orElse(null);
		if(user==null) {
			throw new UsernameNotFoundException(username+"not found");
		}
		
		CustomeUser userD=new CustomeUser(user);
		return userD;
	}

	
	
	
}
