package com.linhtram.springboot.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "thoi_gian_lap")
	private LocalDate thoi_gian_lap;
	
	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	@Column(name = "tong_tien")
	private long tong_tien;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hoadon")
	private DonDat dondat;
	
	public HoaDon() {
		
	}
	
	public HoaDon(LocalDate thoi_gian_lap, String ghi_chu, long tong_tien, DonDat dondat) {
		super();
		this.thoi_gian_lap = thoi_gian_lap;
		this.ghi_chu = ghi_chu;
		this.tong_tien = tong_tien;
		this.dondat = dondat;
	}

	public LocalDate getThoi_gian_lap() {
		return thoi_gian_lap;
	}

	public void setThoi_gian_lap(LocalDate thoi_gian_lap) {
		this.thoi_gian_lap = thoi_gian_lap;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public long getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(long tong_tien) {
		this.tong_tien = tong_tien;
	}

	public DonDat getDondat() {
		return dondat;
	}

	public void setDondat(DonDat dondat) {
		this.dondat = dondat;
	}

	public long getId() {
		return id;
	}
}
