package com.dichvudulich.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "nhanvien")
public class NhanvienEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 10)
	private String manhanvien;
	@NotBlank
	@Size(max = 50)
	private String tennhanvien;
	@NotBlank
	@Size(max = 3)
	private String gioitinh;
	@NotBlank
	private Date ngaysinh;
	@NotBlank
	@Size(max = 11)
	private String sdt;
	@NotBlank
	@Size(max = 255)
	private String email;
	@NotBlank
	@Size(max = 255)
	private String diachi;
	@NotBlank
	@Size(max = 255)
	private String hinhanh;
	@NotBlank
	@Size(max = 255)
	private String ghichu;
	@NotBlank
	private Boolean trangthai;

	@OneToMany(mappedBy = "users")
	private List<UsersEntity> entities = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "id_tintuc")
	private TintucEntity tintuc;
	
	@OneToOne
	@JoinColumn(name = "id_dichvu")
	private DichvuEntity dichvu;

	public NhanvienEntity() {
		super();
	}

	public NhanvienEntity(Long id, @Size(max = 10) String manhanvien, @Size(max = 50) String tennhanvien,
			@Size(max = 3) String gioitinh, Date ngaysinh, @Size(max = 11) String sdt, @Size(max = 255) String email,
			@Size(max = 255) String diachi, @Size(max = 255) String hinhanh, @Size(max = 255) String ghichu,
			Boolean trangthai, List<UsersEntity> entities) {
		super();
		this.id = id;
		this.manhanvien = manhanvien;
		this.tennhanvien = tennhanvien;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.hinhanh = hinhanh;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
		this.entities = entities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}

	public String getTennhanvien() {
		return tennhanvien;
	}

	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public List<UsersEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<UsersEntity> entities) {
		this.entities = entities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
