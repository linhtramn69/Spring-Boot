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

import com.linhtram.springboot.entity.LoaiSanPham;
import com.linhtram.springboot.exception.ResourceNotFoundException;
import com.linhtram.springboot.repository.LoaiSanPhamRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LoaiSanPhamController {
	
	@Autowired
	private LoaiSanPhamRepository loaiSanPhamRepository;
	
	// get all loaisp
	@GetMapping("/loaisanpham")
	public List<LoaiSanPham> getAllLoaiSp(){
		return loaiSanPhamRepository.findAll();
	}
	
	// get loaisp by id
	@GetMapping("/loaisanpham/{id}")
	public ResponseEntity<LoaiSanPham> getLoaiSanPhamById (@PathVariable Long id) {
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm phù hợp với id: " + id));
		return ResponseEntity.ok(loaiSanPham);
	}
	
	// create loaisp
	@PostMapping("/loaisanpham")
	public LoaiSanPham createLoaiSanPham(@RequestBody LoaiSanPham loaiSanPham) {
		System.out.print(loaiSanPham);
		return loaiSanPhamRepository.save(loaiSanPham);
	}
	
	// update loaisp
	@PutMapping("/loaisanpham/{id}")
	public ResponseEntity<LoaiSanPham> updateLoaiSanPham (@PathVariable Long id, @RequestBody LoaiSanPham loaiSanPhamDetails){
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm phù hợp với id: " + id));
			
		loaiSanPham.setTen_loai_sp(loaiSanPhamDetails.getTen_loai_sp());
			
		LoaiSanPham updateLoaiSanPham = loaiSanPhamRepository.save(loaiSanPham);
		return ResponseEntity.ok(updateLoaiSanPham);
	}
	
	// delete loaisp
	@DeleteMapping("/loaisanpham/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLoaiSanPham (@PathVariable Long id){
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm phù hợp với id: " + id));
		loaiSanPhamRepository.delete(loaiSanPham);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
