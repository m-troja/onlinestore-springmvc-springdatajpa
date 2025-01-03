package com.itbulls.learnit.onlinestore.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Repository
public interface SpringDataJpaUserRepo<U> extends CrudRepository<User, Integer> 
{
	@Query("SELECT u FROM user u where LOWER(u.firstName) = :firstName)")
	List<User> getUsersByuFirstNameCaseInsensitive(@Param("firstName") String firstName);
	
	@Query(value = "SELECT * FROM user ORDER BY first_name", nativeQuery = true)
	List<User> getAllUsersOrderByFirstname();
	
	@Query("SELECT u FROM user u where u.email = :email)")
	User findByEmail(@Param("email") String email);

	
	User findByPartnerCode(String partnerCode);

	List<User> findByReferrerUser(int id);
	
	
}
