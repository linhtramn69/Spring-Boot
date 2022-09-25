package com.linhtram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linhtram.springboot.entity.LoaiSanPham;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Long>{

}
