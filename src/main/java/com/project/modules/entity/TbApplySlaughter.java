/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
//import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 屠宰加工申请Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbApplySlaughter extends DataEntity<TbApplySlaughter> {
	
	private static final long serialVersionUID = 1L;
	private String enterpriseType;		// 企业类型
	private String name;		// 企业名称
	private String address;		// 地址
	private String telephoneNumber;		// 电话
	private String contact;		// 联系人
	private Date updateTime;		// update_time
	private Date createTime;		// create_time
	
	public TbApplySlaughter() {
		super();
	}

	public TbApplySlaughter(String id){
		super(id);
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}