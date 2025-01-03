package com.itbulls.learnit.onlinestore.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.entities.Category;

@Repository
public interface SpringDataJpaCategoryRepo extends CrudRepository<Category, Integer>{

	
	@Query
	Category findByCategoryId(int id); 
	
	List<Category> findAll();
	
}
