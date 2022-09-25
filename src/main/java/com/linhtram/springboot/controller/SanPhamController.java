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

import com.linhtram.springboot.entity.SanPham;
import com.linhtram.springboot.exception.ResourceNotFoundException;
import com.linhtram.springboot.repository.SanPhamRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SanPhamController {
	
	@Autowired
	private SanPhamRepository sanPhamRepository;
		
	// get all sanpham
	@GetMapping("/sanpham")
	public List<SanPham> getAllSanPham(){
		return sanPhamRepository.findAll();
	}
	
	// create sanpham
	@PostMapping("/sanpham")
	public SanPham createSanPham(@RequestBody SanPham sanpham) {
		System.out.print(sanpham);
		return sanPhamRepository.save(sanpham);
	}
	
	// get sanpham by id 
	@GetMapping("/sanpham/{id}")
	public ResponseEntity<SanPham> getSanPhamById (@PathVariable Long id) {
		SanPham sanPham = sanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm phù hợp với id: " + id));
		return ResponseEntity.ok(sanPham);
	}
	
	// update sanpham
	@PutMapping("/sanpham/{id}")
	public ResponseEntity<SanPham> updateSanPham (@PathVariable Long id, @RequestBody SanPham sanPhamDetails){
		SanPham sanPham = sanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm phù hợp với id: " + id));
		
		sanPham.setTen_sp(sanPhamDetails.getTen_sp());
		sanPham.setMo_ta(sanPhamDetails.getMo_ta());
		sanPham.setGia_tien(sanPhamDetails.getGia_tien());
		sanPham.setHinh_anh(sanPhamDetails.getHinh_anh());
		sanPham.setLoai_sp(sanPhamDetails.getLoai_sp());
		
		SanPham updateSanPham = sanPhamRepository.save(sanPham);
		return ResponseEntity.ok(updateSanPham);
	}
	
	// delete sanpham
	@DeleteMapping("/sanpham/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSanPham (@PathVariable Long id){
		SanPham sanPham = sanPhamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm phù hợp với id: " + id));
		sanPhamRepository.delete(sanPham);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	


}
