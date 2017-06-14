/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.dao.TbApplySlaughterDao;
import com.project.modules.entity.TbApplySlaughter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 屠宰加工申请Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = false)
public class TbApplySlaughterService extends CrudService<TbApplySlaughterDao, TbApplySlaughter> {

	public TbApplySlaughter get(String id) {
		return super.get(id);
	}
	
	public List<TbApplySlaughter> findList(TbApplySlaughter tbApplySlaughter) {
		return super.findList(tbApplySlaughter);
	}
	
	public Page<TbApplySlaughter> findPage(Page<TbApplySlaughter> page, TbApplySlaughter tbApplySlaughter) {
		return super.findPage(page, tbApplySlaughter);
	}
	
	@Transactional(readOnly = false)
	public void save(TbApplySlaughter tbApplySlaughter) {
		super.save(tbApplySlaughter);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbApplySlaughter tbApplySlaughter) {
		super.delete(tbApplySlaughter);
	}
	
}