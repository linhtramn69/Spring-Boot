package com.linhtram.springboot.entity;

import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "DonDat")
public class DonDat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "thoi_gian_dat")
	private LocalDate thoi_gian_dat;
	
	@Column(name = "dia_chi_nhan")
	private String dia_chi_nhan;
	
	@Column(name = "sdt_nhan")
	private String sdt_nhan;
	
	@Column(name = "li_do_huy")
	private String li_do_huy;
	
	@Column(name = "trang_thai")
	private int trang_thai;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sanpham_dondat", 
				joinColumns =  @JoinColumn(name = "id_dondat"),
				inverseJoinColumns =  @JoinColumn(name = "id_sp"))
//	@ManyToMany(mappedBy = "dondat")
	private List<SanPham> sp = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_hoadon")
	private HoaDon hoadon;

	public DonDat() {
		
	}
	
	public DonDat(LocalDate thoi_gian_dat, String dia_chi_nhan, String sdt_nhan, String li_do_huy, int trang_thai,
			List<SanPham> sp) {
		super();
		this.thoi_gian_dat = thoi_gian_dat;
		this.dia_chi_nhan = dia_chi_nhan;
		this.sdt_nhan = sdt_nhan;
		this.li_do_huy = li_do_huy;
		this.trang_thai = trang_thai;
		this.sp = sp;
	}

	public LocalDate getThoi_gian_dat() {
		return thoi_gian_dat;
	}

	public void setThoi_gian_dat(LocalDate thoi_gian_dat) {
		this.thoi_gian_dat = thoi_gian_dat;
	}

	public String getDia_chi_nhan() {
		return dia_chi_nhan;
	}

	public void setDia_chi_nhan(String dia_chi_nhan) {
		this.dia_chi_nhan = dia_chi_nhan;
	}

	public String getSdt_nhan() {
		return sdt_nhan;
	}

	public void setSdt_nhan(String sdt_nhan) {
		this.sdt_nhan = sdt_nhan;
	}

	public String getLi_do_huy() {
		return li_do_huy;
	}

	public void setLi_do_huy(String li_do_huy) {
		this.li_do_huy = li_do_huy;
	}

	public int getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}

	

//	public HoaDon getHoadon() {
//		return hoadon;
//	}

	public List<SanPham> getSp() {
		return sp;
	}

	public void setSp(List<SanPham> sp) {
		this.sp = sp;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public long getId() {
		return id;
	}
}
