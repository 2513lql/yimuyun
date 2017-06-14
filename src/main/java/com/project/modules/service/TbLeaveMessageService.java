/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.service;

import java.util.List;

import com.project.common.persistence.Page;
import com.project.common.service.CrudService;
import com.project.modules.entity.TbLeaveMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.modules.dao.TbLeaveMessageDao;

/**
 * 留言Service
 * @author LQL
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class TbLeaveMessageService extends CrudService<TbLeaveMessageDao, TbLeaveMessage> {

	public TbLeaveMessage get(String id) {
		return super.get(id);
	}
	
	public List<TbLeaveMessage> findList(TbLeaveMessage tbLeaveMessage) {
		return super.findList(tbLeaveMessage);
	}
	
	public Page<TbLeaveMessage> findPage(Page<TbLeaveMessage> page, TbLeaveMessage tbLeaveMessage) {
		return super.findPage(page, tbLeaveMessage);
	}
	
	@Transactional(readOnly = false)
	public void save(TbLeaveMessage tbLeaveMessage) {
		super.save(tbLeaveMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbLeaveMessage tbLeaveMessage) {
		super.delete(tbLeaveMessage);
	}
	
}