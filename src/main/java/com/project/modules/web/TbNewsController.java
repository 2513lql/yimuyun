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
import com.project.modules.entity.TbNews;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.project.modules.service.TbNewsService;

/**
 * 新闻Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbNews")
public class TbNewsController extends BaseController {

	@Autowired
	private TbNewsService tbNewsService;
	
	@ModelAttribute
	public TbNews get(@RequestParam(required=false) String id) {
		TbNews entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbNewsService.get(id);
		}
		if (entity == null){
			entity = new TbNews();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbNews:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbNews tbNews, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbNews> page = tbNewsService.findPage(new Page<TbNews>(request, response), tbNews);
		model.addAttribute("page", page);
		return "modules/modules/tbNewsList";
	}

	@RequiresPermissions("modules:tbNews:view")
	@RequestMapping(value = "form")
	public String form(TbNews tbNews, Model model) {
		model.addAttribute("tbNews", tbNews);
		return "modules/modules/tbNewsForm";
	}

	@RequiresPermissions("modules:tbNews:edit")
	@RequestMapping(value = "save")
	public String save(TbNews tbNews, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbNews)){
			return form(tbNews, model);
		}
		tbNewsService.save(tbNews);
		addMessage(redirectAttributes, "保存新闻成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbNews/?repage";
	}
	
	@RequiresPermissions("modules:tbNews:edit")
	@RequestMapping(value = "delete")
	public String delete(TbNews tbNews, RedirectAttributes redirectAttributes) {
		tbNewsService.delete(tbNews);
		addMessage(redirectAttributes, "删除新闻成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbNews/?repage";
	}

}