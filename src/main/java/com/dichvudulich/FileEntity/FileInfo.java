package com.dichvudulich.FileEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class FileInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url;

	public FileInfo(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
