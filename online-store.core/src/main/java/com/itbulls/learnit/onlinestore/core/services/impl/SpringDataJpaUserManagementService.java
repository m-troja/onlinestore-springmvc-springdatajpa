package com.itbulls.learnit.onlinestore.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itbulls.learnit.onlinestore.core.mail.MailSender;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.persistence.repo.SpringDataJpaUserRepo;

@Repository
public class SpringDataJpaUserManagementService implements UserManagementService {
	public static final String SUCCESSFULL_REGISTRATION_MESSAGE = "User is registered!";
	private static final String REGISTRATION_ERROR_MESSAGE = "The email is already in use by other user.";

	@Autowired
	SpringDataJpaUserRepo<User> springDataJpaUserRepo;
	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public String registerUser(User user) {
		if ( springDataJpaUserRepo.save(user) != null)
			return SUCCESSFULL_REGISTRATION_MESSAGE;
		else 
		{
			return REGISTRATION_ERROR_MESSAGE;
		}
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) springDataJpaUserRepo.findAll();
	}

	@Override
	public User getUserByEmail(String userEmail) {
		return springDataJpaUserRepo.findByEmail(userEmail);
	}

	@Override
	public void resetPasswordForUser(User user) {
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
		
	}
	
	public User getUserByPartnerCode(String partnerCode)
	{
		return springDataJpaUserRepo.findByPartnerCode(partnerCode);
	}

	public void updateUser(User referrerUser) {
		springDataJpaUserRepo.save(referrerUser);
		
	}

	public List<User> getReferralsByUserId(int id) {
		
		return springDataJpaUserRepo.findByReferrerUser(id);
	}

	public Optional<User> getUserById(Integer userId) {
		return springDataJpaUserRepo.findById(userId);
	}
	
}
