/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.config.Global;
import com.project.common.persistence.Page;
import com.project.common.utils.StringUtils;
import com.project.common.web.BaseController;
import com.project.modules.entity.TbHonor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.project.modules.service.TbHonorService;

/**
 * 公司荣誉Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbHonor")
public class TbHonorController extends BaseController {

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