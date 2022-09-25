package com.linhtram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linhtram.springboot.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}
