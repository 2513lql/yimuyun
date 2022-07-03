/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.entity;

import com.project.common.persistence.DataEntity;
//import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 新闻Entity
 * @author LQL
 * @version 2017-06-13
 */
public class TbNews extends DataEntity<TbNews> {
	
	private static final long serialVersionUID = 1L;
	private String istop;		// 是否置顶
	private String showLocation;		// 展示位置
	private String picture;		// 展示图片
	private String title;		// 标题
	private String body;		// 正文
	private String digest;		// 摘要
	private String author;		// 作者
	private String newsTime;    //新闻详情页显示时间
	private Date updateTime;		// update_time
	private Date createTime;		// create_time
	
	public TbNews() {
		super();
	}

	public TbNews(String id){
		super(id);
	}

	public String getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}

//	@Length(min=0, max=64, message="是否置顶长度必须介于 0 和 64 之间")
	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}
	
//	@Length(min=0, max=64, message="展示位置长度必须介于 0 和 64 之间")
	public String getShowLocation() {
		return showLocation;
	}

	public void setShowLocation(String showLocation) {
		this.showLocation = showLocation;
	}
	
//	@Length(min=0, max=64, message="展示图片长度必须介于 0 和 64 之间")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
//	@Length(min=0, max=64, message="标题长度必须介于 0 和 64 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
//	@Length(min=0, max=255, message="摘要长度必须介于 0 和 255 之间")
	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
//	@Length(min=0, max=64, message="作者长度必须介于 0 和 64 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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