/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 首页信息Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbHomePage extends DataEntity<TbHomePage> {
	
	private static final long serialVersionUID = 1L;
	private String picture1;		// 轮播图1
	private String picture2;		// 轮播图2
	private String picture3;		// 轮播图3
	private String telephoneNumber;		// 电话号
	private Date updateTime;		// update_time
	private Date createTime;		// create_time
	
	public TbHomePage() {
		super();
	}

	public TbHomePage(String id){
		super(id);
	}

//	@Length(min=0, max=64, message="轮播图1长度必须介于 0 和 64 之间")
	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	
//	@Length(min=0, max=64, message="轮播图2长度必须介于 0 和 64 之间")
	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	
//	@Length(min=0, max=64, message="轮播图3长度必须介于 0 和 64 之间")
	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	
//	@Length(min=0, max=64, message="电话号长度必须介于 0 和 64 之间")
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
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