/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.config.Global;
import com.project.common.persistence.Page;
import com.project.common.utils.ConfigUtil;
import com.project.common.utils.StringUtils;
import com.project.common.web.BaseController;
import com.project.modules.entity.TbHonor;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.project.modules.service.TbHonorService;

import java.util.Map;

/**
 * 公司荣誉Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "/honor")
public class TbHonorController extends BaseController {


	@RequestMapping("/page")
	public Map<String,Object> getHonors(Integer pageNo){
		//公司荣誉
		if (pageNo == null || pageNo <= 0){
			pageNo = 1;
		}
		Map<String,Object> map = new HashedMap();
		int pageSize = ConfigUtil.getDefaultPageSize();
		TbHonor honor = new TbHonor();
		Page<TbHonor> params = new Page<TbHonor>(pageNo, pageSize);
		params.setOrderBy("createTime asc");
		Page<TbHonor> page =  tbHonorService.findPage(params,honor);
		int totalCount = tbHonorService.getTotalCount();
		int totalPage =(int) Math.ceil((totalCount * 1.0) / pageSize);
		map.put("totalCount",totalCount);
		map.put("totalPage",totalPage);
		if (page.getList().size() % 3 == 0){ //如果是3的整数倍，则不加</div>
			map.put("isThree","1");
		}else {
			map.put("isThree","0");
		}
		map.put("page",page.getList());
		return map;
	}

	@Autowired
	private TbHonorService tbHonorService;
	
	@ModelAttribute
	public TbHonor get(@RequestParam(required=false) String id) {
		TbHonor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbHonorService.get(id);
		}
		if (entity == null){
			entity = new TbHonor();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbHonor:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbHonor tbHonor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbHonor> page = tbHonorService.findPage(new Page<TbHonor>(request, response), tbHonor);
		model.addAttribute("page", page);
		return "modules/modules/tbHonorList";
	}

	@RequiresPermissions("modules:tbHonor:view")
	@RequestMapping(value = "form")
	public String form(TbHonor tbHonor, Model model) {
		model.addAttribute("tbHonor", tbHonor);
		return "modules/modules/tbHonorForm";
	}

	@RequiresPermissions("modules:tbHonor:edit")
	@RequestMapping(value = "save")
	public String save(TbHonor tbHonor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbHonor)){
			return form(tbHonor, model);
		}
		tbHonorService.save(tbHonor);
		addMessage(redirectAttributes, "保存公司荣誉成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbHonor/?repage";
	}
	
	@RequiresPermissions("modules:tbHonor:edit")
	@RequestMapping(value = "delete")
	public String delete(TbHonor tbHonor, RedirectAttributes redirectAttributes) {
		tbHonorService.delete(tbHonor);
		addMessage(redirectAttributes, "删除公司荣誉成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbHonor/?repage";
	}

}