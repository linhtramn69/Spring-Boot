package com.linhtram.springboot.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ho")
	private String ho;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "ngaysinh")
	private LocalDate ngaysinh;
	
	@Column(name = "phai")
	@Enumerated(EnumType.STRING)
	private Gender phai;
	
	@Column(name = "sdt")
	private String sdt;

	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "id_account")
	private Account account;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	List<DonDat> dondat = new ArrayList<>();
	
	public User() {
		
	}

	public User(String ho, String ten, LocalDate ngaysinh, Gender phai, String sdt) {

		this.ho = ho;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.phai = phai;
		this.sdt = sdt;
	}
	public User(User user) {

		this.ho = user.ho;
		this.ten = user.ten;
		this.ngaysinh = user.ngaysinh;
		this.phai = user.phai;
		this.sdt = user.sdt;
	}
	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public LocalDate getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Gender getPhai() {
		return phai;
	}

	public void setPhai(Gender phai) {
		this.phai = phai;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

//	public Account getAccount() {
//		return account;
//	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<DonDat> getDondat() {
		return dondat;
	}

	public void setDondat(List<DonDat> dondat) {
		this.dondat = dondat;
	}

	public long getId() {
		return id;
	}
}
