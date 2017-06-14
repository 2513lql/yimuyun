/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.entity.TbHonor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.modules.dao.TbHonorDao;

/**
 * 公司荣誉Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class TbHonorService extends CrudService<TbHonorDao, TbHonor> {

	public TbHonor get(String id) {
		return super.get(id);
	}
	
	public List<TbHonor> findList(TbHonor tbHonor) {
		return super.findList(tbHonor);
	}
	
	public Page<TbHonor> findPage(Page<TbHonor> page, TbHonor tbHonor) {
		return super.findPage(page, tbHonor);
	}
	
	@Transactional(readOnly = false)
	public void save(TbHonor tbHonor) {
		super.save(tbHonor);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbHonor tbHonor) {
		super.delete(tbHonor);
	}
	
}