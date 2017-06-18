/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.dao;


import com.project.common.persistence.CrudDao;
import com.project.common.persistence.annotation.MyBatisDao;
import com.project.modules.entity.TbNews;

import java.util.List;

/**
 * 新闻DAO接口
 * @author LQL
 * @version 2017-06-13
 */
@MyBatisDao
public interface TbNewsDao extends CrudDao<TbNews> {
	List<TbNews> getTopThree(String newsType, String istop); //置顶的三则新闻
	List<TbNews> getHangYeZiXuan(String newsType); //行业资讯
	List<TbNews> getCompanyDevelopNews(String newsType); //公司發展歷程
	TbNews getMuslimCulture(String newsType); //清真文化
	Integer getTotalCount(String newsType); //类型新闻数量
}