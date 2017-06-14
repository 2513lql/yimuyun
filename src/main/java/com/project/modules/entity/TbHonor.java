/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 公司荣誉Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbHonor extends DataEntity<TbHonor> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String picture;		// 图片
	private String istop;		// 是否置顶
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	
	public TbHonor() {
		super();
	}

	public TbHonor(String id){
		super(id);
	}

	@Length(min=0, max=255, message="名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="图片长度必须介于 0 和 255 之间")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Length(min=0, max=255, message="是否置顶长度必须介于 0 和 255 之间")
	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}