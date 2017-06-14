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
import com.project.modules.entity.TbApplyFarming;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.modules.service.TbApplyFarmingService;

/**
 * 养殖单位申请Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbApplyFarming")
public class TbApplyFarmingController extends BaseController {

	@Autowired
	private TbApplyFarmingService tbApplyFarmingService;
	
	@ModelAttribute
	public TbApplyFarming get(@RequestParam(required=false) String id) {
		TbApplyFarming entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbApplyFarmingService.get(id);
		}
		if (entity == null){
			entity = new TbApplyFarming();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbApplyFarming:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbApplyFarming tbApplyFarming, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbApplyFarming> page = tbApplyFarmingService.findPage(new Page<TbApplyFarming>(request, response), tbApplyFarming);
		model.addAttribute("page", page);
		return "modules/modules/tbApplyFarmingList";
	}

	@RequiresPermissions("modules:tbApplyFarming:view")
	@RequestMapping(value = "form")
	public String form(TbApplyFarming tbApplyFarming, Model model) {
		model.addAttribute("tbApplyFarming", tbApplyFarming);
		return "modules/modules/tbApplyFarmingForm";
	}

	@RequiresPermissions("modules:tbApplyFarming:edit")
	@RequestMapping(value = "save")
	public String save(TbApplyFarming tbApplyFarming, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbApplyFarming)){
			return form(tbApplyFarming, model);
		}
		tbApplyFarmingService.save(tbApplyFarming);
		addMessage(redirectAttributes, "保存养殖单位申请成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbApplyFarming/?repage";
	}
	
	@RequiresPermissions("modules:tbApplyFarming:edit")
	@RequestMapping(value = "delete")
	public String delete(TbApplyFarming tbApplyFarming, RedirectAttributes redirectAttributes) {
		tbApplyFarmingService.delete(tbApplyFarming);
		addMessage(redirectAttributes, "删除养殖单位申请成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbApplyFarming/?repage";
	}

}