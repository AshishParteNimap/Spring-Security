package com.role_base.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.role_base.model.Permission;
@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long>{

}
