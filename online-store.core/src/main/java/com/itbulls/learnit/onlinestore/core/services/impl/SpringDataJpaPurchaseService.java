package com.itbulls.learnit.onlinestore.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.services.PurchaseManagementService;
import com.itbulls.learnit.onlinestore.persistence.entities.Purchase;
import com.itbulls.learnit.onlinestore.persistence.repo.SpringDataJpaPurchaseRepo;

@Service
public class SpringDataJpaPurchaseService implements PurchaseManagementService {
	
	@Autowired
	private SpringDataJpaPurchaseRepo purchaseRepo;
	
	
	public void addPurchase(Purchase purchase) {
		purchaseRepo.save(purchase);
	}

	public List<Purchase> getPurchasesByUserId(int userId) {
		return purchaseRepo.findByUserId(userId);
		
	}

	public List<Purchase> getPurchases() {
		return (List<Purchase>) purchaseRepo.findAll();
	}

}
