/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 留言Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbLeaveMessage extends DataEntity<TbLeaveMessage> {
	
	private static final long serialVersionUID = 1L;
	private String problemType;		// 问题类型
	private String describe;		// 描述
	private String picture1;		// 图片
	private String picture2;		// 图片
	private String picture3;		// 图片
	private String contact;		// 联系方式
	private Date updateTime;		// update_time
	private Date createTime;		// create_time
	
	public TbLeaveMessage() {
		super();
	}

	public TbLeaveMessage(String id){
		super(id);
	}

	@Length(min=0, max=64, message="问题类型长度必须介于 0 和 64 之间")
	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	
	@Length(min=0, max=64, message="描述长度必须介于 0 和 64 之间")
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	@Length(min=0, max=64, message="图片长度必须介于 0 和 64 之间")
	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	
	@Length(min=0, max=64, message="图片长度必须介于 0 和 64 之间")
	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	
	@Length(min=0, max=64, message="图片长度必须介于 0 和 64 之间")
	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	
	@Length(min=0, max=255, message="联系方式长度必须介于 0 和 255 之间")
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