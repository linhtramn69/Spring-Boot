package com.linhtram.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ten_sp")
	private String ten_sp;
	
	@Column(name = "gia_tien")
	private long gia_tien;
	
	@Column(name = "mo_ta")
	private String mo_ta;
	
	@Column(name = "hinh_anh")
	private String hinh_anh;
	
	@ManyToMany(mappedBy = "sp")
	private List<DonDat> dondat = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_loaisp")
	private LoaiSanPham loai_sp;
	
	public SanPham() {
		
	}

	public SanPham(String ten_sp, long gia_tien, String mo_ta, String hinh_anh, LoaiSanPham loai_sp) {
		super();
		this.ten_sp = ten_sp;
		this.gia_tien = gia_tien;
		this.mo_ta = mo_ta;
		this.hinh_anh = hinh_anh;
		this.loai_sp = loai_sp;
	}

	public LoaiSanPham getLoai_sp() {
		return loai_sp;
	}
	

	public void setLoai_sp(LoaiSanPham loai_sp) {
		this.loai_sp = loai_sp;
	}

	public String getTen_sp() {
		return ten_sp;
	}

	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}

	public long getGia_tien() {
		return gia_tien;
	}

	public void setGia_tien(long gia_tien) {
		this.gia_tien = gia_tien;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	public String getHinh_anh() {
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

	public long getId() {
		return id;
	}
}
