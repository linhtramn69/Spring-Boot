package com.linhtram.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linhtram.springboot.entity.User;
import com.linhtram.springboot.exception.ResourceNotFoundException;
import com.linhtram.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// get all user
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	// create user
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		System.out.print(user);
		return userRepository.save(user);
	}
	
	// get user by id 
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById (@PathVariable Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có user phù hợp với id: " + id));
		return ResponseEntity.ok(user);
	}
	
	// update user
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có user phù hợp với id: " + id));
			
		user.setHo(userDetails.getHo());
		user.setTen(userDetails.getTen());
		user.setPhai(userDetails.getPhai());
		user.setSdt(userDetails.getSdt());
		user.setNgaysinh(userDetails.getNgaysinh());
			
		User updateUser = userRepository.save(user);
		return ResponseEntity.ok(updateUser);
	}
	
	// delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser (@PathVariable Long id){
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có user phù hợp với id: " + id));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
