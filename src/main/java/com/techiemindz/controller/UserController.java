package com.techiemindz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techiemindz.model.User;
import com.techiemindz.service.UserServiceDao;

@RestController
@RequestMapping("/pm/v1")
public class UserController {

	@Autowired
	private UserServiceDao userServiceDao;

	@GetMapping("/test")
	public String getTest() {
		return "Hello, Test Successfull!";
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userServiceDao.getUsers();
	}

	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) {
		return userServiceDao.createUser(user);
	}

	@DeleteMapping("/user/delete")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		System.out.println("UserId:"+userId);
		User user = userServiceDao.findOne(userId);
		Map<String, Boolean> responseMap = new HashMap<String, Boolean>();
		if (user != null) {
			userServiceDao.deleteUser(user);
			responseMap.put("User:" + userId + " Deleted Successfully..", Boolean.TRUE);
		} else {
			responseMap.put("Error In Delete Operation", Boolean.FALSE);
		}
		return responseMap;
	}
	
	
}
