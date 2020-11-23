package com.dichvudulich.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "khachhang")
public class KhachhangEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String taikhoan;
	@NotBlank
	@Size(max = 50)
	private String matkhau;
	@NotBlank
	@Size(max = 100)
	private String tenkhachhang;
	@NotBlank
	private Date ngaysinh;
	@NotBlank
	@Size(max = 11)
	private String sdt;
	@NotBlank
	@Size(max = 100)
	private String diachi;
	@NotBlank
	@Size(max = 100)
	private String email;
	@NotBlank
	@Size(max = 3)
	private String gioitinh;
	@NotBlank
	private Boolean trangthai;
	
	@OneToMany(mappedBy = "khachhang")
	private List<HoadonEntity> entities2 = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "khachhang")
	private List<Dattour> entities = new ArrayList<>();

	public KhachhangEntity() {
		super();
	}

	public KhachhangEntity(Long id, @Size(max = 50) String taikhoan, @Size(max = 50) String matkhau,
			@Size(max = 100) String tenkhachhang, Date ngaysinh, @Size(max = 11) String sdt,
			@Size(max = 100) String diachi, @Size(max = 100) String email, @Size(max = 3) String gioitinh,
			Boolean trangthai) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.tenkhachhang = tenkhachhang;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.diachi = diachi;
		this.email = email;
		this.gioitinh = gioitinh;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
