package com.linhtram.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ten_loai_sp")
	private String ten_loai_sp;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "loai_sp")
	List<SanPham> sp = new ArrayList<>();

	public LoaiSanPham() {
		
	}
	
	public LoaiSanPham(String ten_loai_sp) {
		super();
		this.ten_loai_sp = ten_loai_sp;
	}

	public String getTen_loai_sp() {
		return ten_loai_sp;
	}

	public void setTen_loai_sp(String ten_loai_sp) {
		this.ten_loai_sp = ten_loai_sp;
	}

//	public List<SanPham> getSp() {
//		return sp;
//	}
//
//	public void setSp(List<SanPham> sp) {
//		this.sp = sp;
//	}

	public long getId() {
		return id;
	}
}
