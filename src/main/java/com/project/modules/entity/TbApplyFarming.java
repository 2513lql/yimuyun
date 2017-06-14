/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 养殖单位申请Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbApplyFarming extends DataEntity<TbApplyFarming> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 养殖单位名称
	private String scale;		// 规模
	private String type;		// 类别
	private String picture1;		// 照片
	private String picture2;		// picture2
	private String picture3;		// picture3
	private String telephoneNumber;		// 电话
	private Date updateTime;		// update_time
	private Date createTime;		// create_time
	
	public TbApplyFarming() {
		super();
	}

	public TbApplyFarming(String id){
		super(id);
	}

	@Length(min=0, max=64, message="养殖单位名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="规模长度必须介于 0 和 64 之间")
	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}
	
	@Length(min=0, max=64, message="类别长度必须介于 0 和 64 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="照片长度必须介于 0 和 64 之间")
	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	
	@Length(min=0, max=64, message="picture2长度必须介于 0 和 64 之间")
	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	
	@Length(min=0, max=64, message="picture3长度必须介于 0 和 64 之间")
	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	
	@Length(min=0, max=64, message="电话长度必须介于 0 和 64 之间")
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