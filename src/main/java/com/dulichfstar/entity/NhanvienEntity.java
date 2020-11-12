package com.dulichfstar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanvienEntity extends BaseEntity {
	@Column(name = "manhanvien")
	private String manhanvien;

	@Column(name = "hovaten")
	private String hovaten;

	@Column(name = "ngaysinh")
	private Date ngaysinh;

	@Column(name = "gioitinh")
	private String gioitinh;

	@Column(name = "email")
	private String email;

	@Column(name = "sdt")
	private String sdt;

	@Column(name = "diachi")
	private String diachi;

	@Column(name = "hinhanh")
	private Date hinhanh;

	@Column(name = "ghichu")
	private Date ghichu;

	@OneToMany(mappedBy = "taikhoan")
	private List<TaikhoanEntity> taikhoan = new ArrayList<>();

	public List<TintucEntity> getTintuc() {
		return tintuc;
	}

	public void setTintuc(List<TintucEntity> tintuc) {
		this.tintuc = tintuc;
	}

	@OneToMany(mappedBy = "tintuc")
	private List<TintucEntity> tintuc = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "id_nhanvien")
	private NhanvienEntity nhanvien;

	public String getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(Date hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Date getGhichu() {
		return ghichu;
	}

	public void setGhichu(Date ghichu) {
		this.ghichu = ghichu;
	}

	public List<TaikhoanEntity> getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(List<TaikhoanEntity> taikhoan) {
		this.taikhoan = taikhoan;
	}

}
