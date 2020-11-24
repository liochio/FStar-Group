package com.dichvudulich.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "loaitour")
public class LoaitourEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 10)
	private String maloaitour;
	@NotBlank
	@Size(max = 50)
	private String tenloaitour;
	@NotBlank
	private String trangthai;
	
	@OneToMany(mappedBy = "loaitour")
	private List<TourEntity> entities = new ArrayList<>();

	public LoaitourEntity() {
		super();
	}

	public LoaitourEntity(@Size(max = 10) String maloaitour, @Size(max = 50) String tenloaitour, String trangthai) {
		super();
		this.id = id;
		this.maloaitour = maloaitour;
		this.tenloaitour = tenloaitour;
		this.trangthai = trangthai;
		this.entities = entities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaloaitour() {
		return maloaitour;
	}

	public void setMaloaitour(String maloaitour) {
		this.maloaitour = maloaitour;
	}

	public String getTenloaitour() {
		return tenloaitour;
	}

	public void setTenloaitour(String tenloaitour) {
		this.tenloaitour = tenloaitour;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
