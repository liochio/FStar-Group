package com.dulichfstar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loaitintuc")
public class LoaitintucEntity extends BaseEntity {

	@Column(name = "matintuc")
	private String matintuc;

	@Column(name = "tentintuc")
	private String tentintuc;

	@Column(name = "trangthai")
	private Boolean trangthai;

	@OneToMany(mappedBy = "loaitintuc")
	private List<LoaitintucEntity> loaitintuc = new ArrayList<>();

	public String getMatintuc() {
		return matintuc;
	}

	public void setMatintuc(String matintuc) {
		this.matintuc = matintuc;
	}

	public String getTentintuc() {
		return tentintuc;
	}

	public void setTentintuc(String tentintuc) {
		this.tentintuc = tentintuc;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public List<LoaitintucEntity> getLoaitintuc() {
		return loaitintuc;
	}

	public void setLoaitintuc(List<LoaitintucEntity> loaitintuc) {
		this.loaitintuc = loaitintuc;
	}

}
