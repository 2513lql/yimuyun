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
import com.project.modules.entity.TbHomePage;
import com.project.modules.service.TbHomePageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 * 首页信息Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbHomePage")
public class TbHomePageController extends BaseController {

	@Autowired
	private TbHomePageService tbHomePageService;
	
	@ModelAttribute
	public TbHomePage get(@RequestParam(required=false) String id) {
		TbHomePage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbHomePageService.get(id);
		}
		if (entity == null){
			entity = new TbHomePage();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbHomePage:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbHomePage tbHomePage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbHomePage> page = tbHomePageService.findPage(new Page<TbHomePage>(request, response), tbHomePage);
		model.addAttribute("page", page);
		return "modules/modules/tbHomePageList";
	}

	@RequiresPermissions("modules:tbHomePage:view")
	@RequestMapping(value = "form")
	public String form(TbHomePage tbHomePage, Model model) {
		model.addAttribute("tbHomePage", tbHomePage);
		return "modules/modules/tbHomePageForm";
	}

	@RequiresPermissions("modules:tbHomePage:edit")
	@RequestMapping(value = "save")
	public String save(TbHomePage tbHomePage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbHomePage)){
			return form(tbHomePage, model);
		}
		tbHomePageService.save(tbHomePage);
		addMessage(redirectAttributes, "保存首页信息成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbHomePage/?repage";
	}
	
	@RequiresPermissions("modules:tbHomePage:edit")
	@RequestMapping(value = "delete")
	public String delete(TbHomePage tbHomePage, RedirectAttributes redirectAttributes) {
		tbHomePageService.delete(tbHomePage);
		addMessage(redirectAttributes, "删除首页信息成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbHomePage/?repage";
	}

}