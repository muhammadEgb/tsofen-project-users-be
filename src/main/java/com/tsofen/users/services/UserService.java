package com.tsofen.users.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsofen.users.beans.User;
import com.tsofen.users.beans.UserLoginData;
import com.tsofen.users.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	public void addUser(User user) {
		Optional<User> exists = repo.findByEmail(user.getEmail());
		if(exists.isPresent() && !exists.isEmpty())
			throw new IllegalStateException("User #" + exists.get().getId() + "-" + 
					   exists.get().getFname() + " " + exists.get().getLname() +" Already Exists!");
		else
			repo.save(user);
	}
	
	public boolean userLogin(UserLoginData userLoginData) {
		Optional<User> user = repo.findByEmail(userLoginData.getEmail());
		if(!user.isPresent() || user.isEmpty())
			return false;
		else
			if(userLoginData.getPassword().equals(user.get().getPassword()))
				return true;
			else
				return false;
	}

	@Transactional
	public void editUser(User user) {
		Optional<User> user2change = repo.findByEmail(user.getEmail());
		user.setId(user2change.get().getId());
		repo.save(user);
	}

	public List<User> getUsersByStatus(boolean status) {
		return repo.findAllByStatus(status);
	}
	
}
