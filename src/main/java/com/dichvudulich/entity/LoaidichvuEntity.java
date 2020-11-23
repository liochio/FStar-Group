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
@Table(name = "loaidichvu")
public class LoaidichvuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 10)
	private String maloaidichvu;
	@NotBlank
	@Size(max = 50)
	private String tenloaidichvu;
	@NotBlank
	private Boolean trangthai;

	@OneToMany(mappedBy = "loaidichvu")
	private List<DichvuEntity> entities = new ArrayList<>();

	public LoaidichvuEntity() {
		super();
	}

	public LoaidichvuEntity(Long id, @Size(max = 10) String maloaidichvu, @Size(max = 50) String tenloaidichvu,
			Boolean trangthai) {
		super();
		this.id = id;
		this.maloaidichvu = maloaidichvu;
		this.tenloaidichvu = tenloaidichvu;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaloaidichvu() {
		return maloaidichvu;
	}

	public void setMaloaidichvu(String maloaidichvu) {
		this.maloaidichvu = maloaidichvu;
	}

	public String getTenloaidichvu() {
		return tenloaidichvu;
	}

	public void setTenloaidichvu(String tenloaidichvu) {
		this.tenloaidichvu = tenloaidichvu;
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
