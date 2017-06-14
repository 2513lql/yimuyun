/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.entity.TbApplyFarming;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.modules.dao.TbApplyFarmingDao;

/**
 * 养殖单位申请Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = false)
public class TbApplyFarmingService extends CrudService<TbApplyFarmingDao, TbApplyFarming> {

	public TbApplyFarming get(String id) {
		return super.get(id);
	}
	
	public List<TbApplyFarming> findList(TbApplyFarming tbApplyFarming) {
		return super.findList(tbApplyFarming);
	}
	
	public Page<TbApplyFarming> findPage(Page<TbApplyFarming> page, TbApplyFarming tbApplyFarming) {
		return super.findPage(page, tbApplyFarming);
	}
	
	@Transactional(readOnly = false)
	public void save(TbApplyFarming tbApplyFarming) {
		super.save(tbApplyFarming);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbApplyFarming tbApplyFarming) {
		super.delete(tbApplyFarming);
	}
	
}