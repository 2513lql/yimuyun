/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.common.utils.ConfigUtil;
import com.project.modules.entity.TbNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.modules.dao.TbNewsDao;

/**
 * 新闻Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class TbNewsService extends CrudService<TbNewsDao, TbNews> {

	@Autowired
	private TbNewsDao tbNewsDao;

	public List<TbNews> getTopThree(String newsType){
		String istop = ConfigUtil.getNewsIsTop();
		List<TbNews> tbNews = tbNewsDao.getTopThree(newsType,istop);
//		for(TbNews news : tbNews){
//			news.setDigest(news.getDigest().substring(0,20));
//		}
		return tbNews;
	}

	/**
	 * 查询行业快讯
	 * @return
     */
	public List<TbNews> getHangYeZiXuan(){
		String newsType = ConfigUtil.getIndustryNewsLocation();
		return tbNewsDao.getHangYeZiXuan(newsType);
	}

	/**
	 * 公司发展历程
	 * @return
     */
	public List<TbNews> getCompanyDevelopNews(){
		String newsType = ConfigUtil.getDevelopmentHistoryNewsLocation();
		return tbNewsDao.getCompanyDevelopNews(newsType);
	}

	/**
	 * 清真文化
	 * @return
     */
	public TbNews getMuslimCultrue(){
		String newsType = ConfigUtil.getMuslimCultureNewsLocation();
		return tbNewsDao.getMuslimCulture(newsType);
	}

	/**
	 * 查询公司新闻总数
	 * @return
	 */
	public Integer getTotalCount(){
		String newsType = ConfigUtil.getCompanyNewsLocation();
		return tbNewsDao.getTotalCount(newsType);
	}

	public TbNews get(String id) {
		return super.get(id);
	}
	
	public List<TbNews> findList(TbNews tbNews) {
		return super.findList(tbNews);
	}
	
	public Page<TbNews> findPage(Page<TbNews> page, TbNews tbNews) {
		return super.findPage(page, tbNews);
	}
	
	@Transactional(readOnly = false)
	public void save(TbNews tbNews) {
		super.save(tbNews);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbNews tbNews) {
		super.delete(tbNews);
	}
	
}