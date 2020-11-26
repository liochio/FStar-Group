package com.dichvudulich.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoaiTintucEntityRequest {

	@NotBlank
	@Size(max = 10)
	private String maloaitintuc;
	@NotBlank
	@Size(max = 50)
	private String tenloaitintuc;
	private Boolean trangthai;

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

}
