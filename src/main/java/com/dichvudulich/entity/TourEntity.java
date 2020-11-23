package com.dichvudulich.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tour")
public class TourEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 255)
	private String mota;
	@NotBlank
	@Size(max = 255)
	private String motachitiet;
	@NotBlank
	@Size(max = 100)
	private String hinhanh;
	@NotBlank
	private Long gia;
	@NotBlank
	@Size(max = 100)
	private String diadiem;
	@NotBlank
	private Date thoigiankhoihanh;
	@NotBlank
	private Integer soluongkhach;
	@NotBlank
	private Boolean trangthai;

	@OneToOne
	@JoinColumn(name = "id_loaitour")
	private LoaitourEntity loaitour;

	public TourEntity() {
		super();
	}

	public TourEntity(Long id, @Size(max = 255) String mota, @Size(max = 255) String motachitiet,
			@Size(max = 100) String hinhanh, Long gia, @Size(max = 100) String diadiem, Date thoigiankhoihanh,
			Integer soluongkhach, Boolean trangthai, LoaitourEntity loaitour) {
		super();
		this.id = id;
		this.mota = mota;
		this.motachitiet = motachitiet;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.diadiem = diadiem;
		this.thoigiankhoihanh = thoigiankhoihanh;
		this.soluongkhach = soluongkhach;
		this.trangthai = trangthai;
		this.loaitour = loaitour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getMotachitiet() {
		return motachitiet;
	}

	public void setMotachitiet(String motachitiet) {
		this.motachitiet = motachitiet;
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

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public Date getThoigiankhoihanh() {
		return thoigiankhoihanh;
	}

	public void setThoigiankhoihanh(Date thoigiankhoihanh) {
		this.thoigiankhoihanh = thoigiankhoihanh;
	}

	public Integer getSoluongkhach() {
		return soluongkhach;
	}

	public void setSoluongkhach(Integer soluongkhach) {
		this.soluongkhach = soluongkhach;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public LoaitourEntity getLoaitour() {
		return loaitour;
	}

	public void setLoaitour(LoaitourEntity loaitour) {
		this.loaitour = loaitour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
