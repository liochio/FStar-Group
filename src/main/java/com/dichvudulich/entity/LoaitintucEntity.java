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
@Table(name = "loaitintuc")
public class LoaitintucEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 10)
	private String maloaitintuc;
	@NotBlank
	@Size(max = 50)
	private String tenloaitintuc;
	@NotBlank
	private Boolean trangthai;

	@OneToMany(mappedBy = "loaitintuc")
	private List<TintucEntity> entities = new ArrayList<>();

	public LoaitintucEntity() {
		super();
	}

	public LoaitintucEntity(Long id, @Size(max = 10) String maloaitintuc, @Size(max = 255) String tenloaitintuc,
			Boolean trangthai) {
		super();
		this.id = id;
		this.maloaitintuc = maloaitintuc;
		this.tenloaitintuc = tenloaitintuc;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaloaitintuc() {
		return maloaitintuc;
	}

	public void setMaloaitintuc(String maloaitintuc) {
		this.maloaitintuc = maloaitintuc;
	}

	public String getTenloaitintuc() {
		return tenloaitintuc;
	}

	public void setTenloaitintuc(String tenloaitintuc) {
		this.tenloaitintuc = tenloaitintuc;
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
