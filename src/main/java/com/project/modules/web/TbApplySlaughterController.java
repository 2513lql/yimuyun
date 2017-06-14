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
import com.project.modules.entity.TbApplySlaughter;
import com.project.modules.service.TbApplySlaughterService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 屠宰加工申请Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbApplySlaughter")
public class TbApplySlaughterController extends BaseController {

	@Autowired
	private TbApplySlaughterService tbApplySlaughterService;
	
	@ModelAttribute
	public TbApplySlaughter get(@RequestParam(required=false) String id) {
		TbApplySlaughter entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbApplySlaughterService.get(id);
		}
		if (entity == null){
			entity = new TbApplySlaughter();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbApplySlaughter:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbApplySlaughter tbApplySlaughter, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbApplySlaughter> page = tbApplySlaughterService.findPage(new Page<TbApplySlaughter>(request, response), tbApplySlaughter);
		model.addAttribute("page", page);
		return "modules/modules/tbApplySlaughterList";
	}

	@RequiresPermissions("modules:tbApplySlaughter:view")
	@RequestMapping(value = "form")
	public String form(TbApplySlaughter tbApplySlaughter, Model model) {
		model.addAttribute("tbApplySlaughter", tbApplySlaughter);
		return "modules/modules/tbApplySlaughterForm";
	}

	@RequiresPermissions("modules:tbApplySlaughter:edit")
	@RequestMapping(value = "save")
	public String save(TbApplySlaughter tbApplySlaughter, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbApplySlaughter)){
			return form(tbApplySlaughter, model);
		}
		tbApplySlaughterService.save(tbApplySlaughter);
		addMessage(redirectAttributes, "保存屠宰加工申请成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbApplySlaughter/?repage";
	}
	
	@RequiresPermissions("modules:tbApplySlaughter:edit")
	@RequestMapping(value = "delete")
	public String delete(TbApplySlaughter tbApplySlaughter, RedirectAttributes redirectAttributes) {
		tbApplySlaughterService.delete(tbApplySlaughter);
		addMessage(redirectAttributes, "删除屠宰加工申请成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbApplySlaughter/?repage";
	}

}