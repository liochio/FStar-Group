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
@Table(name = "tintuc")
public class TintucEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String tieude;
	@NotBlank
	@Size(max = 255)
	private String noidung;
	@NotBlank
	@Size(max = 255)
	private String hinhanh;
	@NotBlank
	private Boolean trangthai;
	
	@NotBlank
	private Date thoigian;

	@OneToOne
	@JoinColumn(name = "id_loaitintuc")
	private LoaitintucEntity loaitintuc;

	@OneToMany(mappedBy = "tintuc")
	private List<NhanvienEntity> entities = new ArrayList<>();

	public TintucEntity() {
		super();
	}

	public TintucEntity(Long id, @Size(max = 100) String tieude, @Size(max = 255) String noidung,
			@Size(max = 255) String hinhanh, Boolean trangthai, Date thoigian, LoaitintucEntity loaitintuc,
			List<NhanvienEntity> entities) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.noidung = noidung;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.thoigian = thoigian;
		this.loaitintuc = loaitintuc;
		this.entities = entities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public LoaitintucEntity getLoaitintuc() {
		return loaitintuc;
	}

	public void setLoaitintuc(LoaitintucEntity loaitintuc) {
		this.loaitintuc = loaitintuc;
	}

	public List<NhanvienEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<NhanvienEntity> entities) {
		this.entities = entities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
