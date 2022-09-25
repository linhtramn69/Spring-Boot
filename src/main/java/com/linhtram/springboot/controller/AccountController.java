package com.linhtram.springboot.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

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

import com.linhtram.springboot.entity.Account;
import com.linhtram.springboot.entity.User;
import com.linhtram.springboot.repository.AccountRepository;
import com.linhtram.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
		
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	// get all account
	@GetMapping("/account")
	public List<Account> getAllAccount(){
		return accountRepository.findAll();
	}
	
	// update account
	@PutMapping("/account/{username}")
	public ResponseEntity<Account> updateAccount (@PathVariable String username, @RequestBody Account accountDetails){
		Account account = accountRepository.getById(username);
				
		account.setPassword(accountDetails.getPassword());
			
		Account updateAccount = accountRepository.save(account);
		
		return ResponseEntity.ok(updateAccount);
	}
	
	// delete user
	@DeleteMapping("/account/{username}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount (@PathVariable String username){
		Account account = accountRepository.getById(username);
		accountRepository.delete(account);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// login
	@PostMapping("/login")
	public User login(@RequestBody Account account) {
		try{Account acc =  accountRepository.getById(account.getUsername());
		if(acc.getPassword().equals(account.getPassword())) {
			return acc.getUser();
		}
		return null;}
		catch(EntityNotFoundException e) {return null;}
	}
	
	// register
	@PostMapping("/register") 
	public boolean createUser(@RequestBody User user ) {
		userRepository.save(user);
		return true;
	}
	
}
