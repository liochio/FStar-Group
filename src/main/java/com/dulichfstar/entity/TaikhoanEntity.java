package com.dulichfstar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taikhoan")

public class TaikhoanEntity extends BaseEntity {
	@Column(name = "username")
	private String username;

	@Column(name = "matkhau")
	private String matkhau;

	@Column(name = "vaitro")
	private String vaitro;

	@ManyToOne
	@JoinColumn(name = "id_nhanvien")
	private NhanvienEntity taikhoan;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getVaitro() {
		return vaitro;
	}

	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}

	public NhanvienEntity getTaikhoans() {
		return taikhoan;
	}

	public void setTaikhoans(NhanvienEntity taikhoan) {
		this.taikhoan = taikhoan;
	}

	
}
