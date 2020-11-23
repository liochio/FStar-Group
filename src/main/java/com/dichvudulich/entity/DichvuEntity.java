package com.dichvudulich.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "dichvu")
public class DichvuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String tieude;
	@NotBlank
	@Size(max = 255)
	private String mota;
	@NotBlank
	@Size(max = 255)
	private String hinhanh;
	@NotBlank
	private Long gia;
	@NotBlank
	private Boolean trangthai;
	
	@OneToOne
	@JoinColumn(name = "id_loaidichvu")
	private LoaidichvuEntity loaidichvu;
	
	@OneToMany(mappedBy = "dichvu")
	private List<NhanvienEntity> entities = new ArrayList<>();

	public DichvuEntity() {
		super();
	}

	public DichvuEntity(Long id, @Size(max = 100) String tieude, @Size(max = 255) String mota,
			@Size(max = 255) String hinhanh, Long gia, Boolean trangthai) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.mota = mota;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.trangthai = trangthai;
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
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
