package com.linhtram.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linhtram.springboot.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>{

//	List<SanPham> findByIdLoaiSp(Long id);
}
