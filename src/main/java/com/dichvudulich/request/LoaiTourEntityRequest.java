package com.dichvudulich.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoaiTourEntityRequest {

	@NotBlank
	@Size(max = 10)
	private String maloaitour;
	@NotBlank
	@Size(max = 50)
	private String tenloaitour;
	private Boolean trangthai;

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

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean b) {
		this.trangthai = b;
	}

}
