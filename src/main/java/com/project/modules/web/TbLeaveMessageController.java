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
import com.project.modules.entity.TbLeaveMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.project.modules.service.TbLeaveMessageService;

/**
 * 留言Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/xinda/tbLeaveMessage")
public class TbLeaveMessageController extends BaseController {

	@Autowired
	private TbLeaveMessageService tbLeaveMessageService;
	
	@ModelAttribute
	public TbLeaveMessage get(@RequestParam(required=false) String id) {
		TbLeaveMessage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbLeaveMessageService.get(id);
		}
		if (entity == null){
			entity = new TbLeaveMessage();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbLeaveMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbLeaveMessage tbLeaveMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbLeaveMessage> page = tbLeaveMessageService.findPage(new Page<TbLeaveMessage>(request, response), tbLeaveMessage);
		model.addAttribute("page", page);
		return "modules/modules/tbLeaveMessageList";
	}

	@RequiresPermissions("modules:tbLeaveMessage:view")
	@RequestMapping(value = "form")
	public String form(TbLeaveMessage tbLeaveMessage, Model model) {
		model.addAttribute("tbLeaveMessage", tbLeaveMessage);
		return "modules/modules/tbLeaveMessageForm";
	}

	@RequiresPermissions("modules:tbLeaveMessage:edit")
	@RequestMapping(value = "save")
	public String save(TbLeaveMessage tbLeaveMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbLeaveMessage)){
			return form(tbLeaveMessage, model);
		}
		tbLeaveMessageService.save(tbLeaveMessage);
		addMessage(redirectAttributes, "保存留言成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbLeaveMessage/?repage";
	}
	
	@RequiresPermissions("modules:tbLeaveMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(TbLeaveMessage tbLeaveMessage, RedirectAttributes redirectAttributes) {
		tbLeaveMessageService.delete(tbLeaveMessage);
		addMessage(redirectAttributes, "删除留言成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbLeaveMessage/?repage";
	}

}