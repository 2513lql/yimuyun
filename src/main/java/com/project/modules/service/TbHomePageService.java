/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.dao.TbHomePageDao;
import com.project.modules.entity.TbHomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 首页信息Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class TbHomePageService extends CrudService<TbHomePageDao, TbHomePage> {

	@Autowired
	private TbHomePageDao tbHomePageDao;

	public TbHomePage getHomePage(){
		List<TbHomePage> homePages = tbHomePageDao.getHomePage();
		return homePages.get(0);
	}

	public TbHomePage get(String id) {
		return super.get(id);
	}

	public List<TbHomePage> findList(TbHomePage tbHomePage) {
		return super.findList(tbHomePage);
	}
	
	public Page<TbHomePage> findPage(Page<TbHomePage> page, TbHomePage tbHomePage) {
		return super.findPage(page, tbHomePage);
	}

	@Transactional(readOnly = false)
	public void save(TbHomePage tbHomePage) {
		super.save(tbHomePage);
	}

	@Transactional(readOnly = false)
	public void delete(TbHomePage tbHomePage) {
		super.delete(tbHomePage);
	}
	
}