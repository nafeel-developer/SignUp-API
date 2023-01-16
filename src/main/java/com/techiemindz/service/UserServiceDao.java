package com.techiemindz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techiemindz.model.User;
import com.techiemindz.repository.UserRepository;

@Component
public class UserServiceDao {

	@Autowired
	private UserRepository userRepository;

	public User findOne(long id) {
		for (User user : userRepository.findAll()) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
