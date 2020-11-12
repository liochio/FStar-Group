package com.dulichfstar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tintuc")
public class TintucEntity extends BaseEntity {
	
	@Column(name = "tieude")
	private String tieude;
	
	@Column(name = "noidung")
	private String noidung;
	
	@Column(name = "hinhanh")
	private String hinhanh;
	
	@Column(name = "trangthai")
	private Boolean trangthai;
	
	@ManyToOne
	@JoinColumn(name = "id_nhanvien")
	private NhanvienEntity tintuc;
	
	@ManyToOne
	@JoinColumn(name = "id_loaitintuc")
	private LoaitintucEntity loaitintuc;

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public NhanvienEntity getTintuc() {
		return tintuc;
	}

	public void setTintuc(NhanvienEntity tintuc) {
		this.tintuc = tintuc;
	}
	
	
	
}
