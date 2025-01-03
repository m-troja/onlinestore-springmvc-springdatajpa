package com.itbulls.learnit.onlinestore.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.persistence.entities.Purchase;

@Repository
public interface SpringDataJpaPurchaseRepo extends CrudRepository<Purchase,Integer>{

	@Query("SELECT p FROM purchase p WHERE p.user.id = :id")
	List<Purchase> findByUserId(int userId);
	
//	List<Purchase> findAll();
	
	@Query("SELECT p.id, p.user, p.purchaseStatusDto FROM purchase p WHERE p.purchaseStatus.id != :statusId;")
	 List<Purchase> getNotCompletedPurchases(Integer lastFulfilmentStageId);
	 
	
	 Purchase getPurchaseById(Integer purchaseId);
}
