package com.linhtram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linhtram.springboot.entity.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long>{

}
