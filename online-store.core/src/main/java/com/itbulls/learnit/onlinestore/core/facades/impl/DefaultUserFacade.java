package com.itbulls.learnit.onlinestore.core.facades.impl;

import static com.itbulls.learnit.onlinestore.persistence.dto.RoleDto.CUSTOMER_ROLE_NAME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.services.AffiliateMarketingService;
import com.itbulls.learnit.onlinestore.core.services.impl.SpringDataJpaUserManagementService;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Service
public class DefaultUserFacade implements UserFacade {
	
	@Autowired
	private SpringDataJpaUserManagementService userManagement;
	
	@Autowired
	private AffiliateMarketingService marketingService;
	

	@Override
	public void registerUser(User user, String referrerCode) {
		user.setRoleName(CUSTOMER_ROLE_NAME);
		user.setPartnerCode(marketingService.generateUniquePartnerCode());
		user.setReferrerUser(userManagement.getUserByPartnerCode(referrerCode));
		userManagement.registerUser(user);
	}


	@Override
	public User getUserByEmail(String email) {
		return (userManagement.getUserByEmail(email));
	}

	@Override
	public List<User> getUsers() {
		return (userManagement.getUsers());
	}

	@Override
	public User getUserById(Integer userId) {
		return (userManagement.getUserById(userId));
	}

	@Override
	public void updateUser(User referrerUser) {
		userManagement.updateUser(referrerUser);
	}

	@Override
	public List<User> getReferralsForUser(User loggedInUser) {
		return userManagement.getReferralsByUserId(loggedInUser.getId());
	}
}
