package com.linhtram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linhtram.springboot.entity.DonDat;

@Repository
public interface DonDatRepository extends JpaRepository<DonDat, Long>{

}
