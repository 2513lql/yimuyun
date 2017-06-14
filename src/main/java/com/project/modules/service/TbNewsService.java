/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.entity.TbNews;
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