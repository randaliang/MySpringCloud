package com.superhope.eleclient;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date create_time;
	
	@JsonProperty("paerntId")
	private String parent_id;

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
}
