package com.eshop.product.web.formbean;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class ProductTypeFormBean extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3345249492832786548L;
	private Integer typeId;
	private String name;
	private String note;
	private Integer parentId;
	private Date createTime;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
