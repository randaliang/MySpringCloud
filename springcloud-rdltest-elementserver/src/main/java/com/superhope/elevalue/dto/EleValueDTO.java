package com.superhope.elevalue.dto;

import java.sql.Date;

public class EleValueDTO {
	
	public String getElename() {
		return elename;
	}

	public void setElename(String elename) {
		this.elename = elename;
	}

	private String elename;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private String code;
	
	private String name;
	
	private Date createDate;
	
}
