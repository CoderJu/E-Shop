package com.eshop.product.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="producttype")
public class ProductTypeBean {

	private Integer typeId;
	private String name;
	private String note;
	private Boolean visible=true;
	private Date createTime = new Date();
	private Set<ProductTypeBean> childTypeBean = new HashSet<ProductTypeBean>();//子类
	private  ProductTypeBean parentType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	@Column(length=36,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=200)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(nullable=false)
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	@Column(nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parentType")
	public Set<ProductTypeBean> getChildTypeBean() {
		return childTypeBean;
	}
	public void setChildTypeBean(Set<ProductTypeBean> childTypeBean) {
		this.childTypeBean = childTypeBean;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "parentTypeId")
	public ProductTypeBean getParentType() {
		return parentType;
	}
	public void setParentType(ProductTypeBean parentType) {
		this.parentType = parentType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductTypeBean other = (ProductTypeBean) obj;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}

}
