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

import com.linhtram.springboot.entity.DonDat;
import com.linhtram.springboot.exception.ResourceNotFoundException;
import com.linhtram.springboot.repository.DonDatRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DonDatController {
	
	@Autowired
	private DonDatRepository donDatRepository;
	
	// get all dondat
	@GetMapping("/dondat")
	public List<DonDat> getAllDonDat(){
		return donDatRepository.findAll();
	}
	
	// get dondat by id 
	@GetMapping("/dondat/{id}")
	public ResponseEntity<DonDat> getSanPhamById (@PathVariable Long id) {
		DonDat dondat = donDatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt phù hợp với id: " + id));
		return ResponseEntity.ok(dondat);
	}
	
	// create dondat
	@PostMapping("/dondat")
	public DonDat createDonDat(@RequestBody DonDat dondat) {
		System.out.print(dondat);
		return donDatRepository.save(dondat);
	}

	// update dondat
	@PutMapping("/dondat/{id}")
	public ResponseEntity<DonDat> updateDonDat (@PathVariable Long id, @RequestBody DonDat donDatDetails){
		DonDat donDat = donDatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt phù hợp với id: " + id));
		
		donDat.setDia_chi_nhan(donDatDetails.getDia_chi_nhan());
		donDat.setLi_do_huy(donDatDetails.getLi_do_huy());
		donDat.setSdt_nhan(donDatDetails.getSdt_nhan());
		donDat.setThoi_gian_dat(donDatDetails.getThoi_gian_dat());
		donDat.setTrang_thai(donDatDetails.getTrang_thai());
		donDat.setSp(donDatDetails.getSp());
			
		DonDat updateDonDat = donDatRepository.save(donDat);
		return ResponseEntity.ok(updateDonDat);
	}
	
	// delete dondat
	@DeleteMapping("/dondat/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDonDat (@PathVariable Long id){
		DonDat dondat = donDatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt phù hợp với id: " + id));
		donDatRepository.delete(dondat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
