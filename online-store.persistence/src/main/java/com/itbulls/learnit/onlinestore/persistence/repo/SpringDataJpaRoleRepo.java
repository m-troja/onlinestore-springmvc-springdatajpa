package com.itbulls.learnit.onlinestore.persistence.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.entities.Role;

@Repository
public interface SpringDataJpaRoleRepo<R> extends CrudRepository<Role, Integer>
{
	Role findById(int id);

	Role findByRoleName(String roleName);
}
