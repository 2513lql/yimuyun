/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.dao;

import com.project.common.persistence.CrudDao;
import com.project.common.persistence.annotation.MyBatisDao;
import com.project.modules.entity.TbApplyFarming;

/**
 * 养殖单位申请DAO接口
 * @author LQL
 * @version 2017-06-13
 */
@MyBatisDao
public interface TbApplyFarmingDao extends CrudDao<TbApplyFarming> {
	
}