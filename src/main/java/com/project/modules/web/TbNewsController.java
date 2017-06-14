/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.config.Global;
import com.project.common.persistence.Page;
import com.project.common.utils.ConfigUtil;
import com.project.common.utils.DateUtil;
import com.project.common.utils.StringUtils;
import com.project.common.web.BaseController;
import com.project.modules.entity.TbHomePage;
import com.project.modules.entity.TbNews;
import com.project.modules.service.TbHomePageService;
import com.sun.javafx.collections.MappingChange;
import org.apache.poi.ss.formula.functions.Mode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.project.modules.service.TbNewsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新闻Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping("/news")
public class TbNewsController extends BaseController {

	@Autowired
	private TbNewsService tbNewsService;
	@Autowired
	private TbHomePageService tbHomePageService;

	/**
	 * 新闻中心
	 * @return
     */
	@RequestMapping("/center")
	public ModelAndView newsCenter(){
		ModelAndView modelAndView = new ModelAndView();
		List<TbNews> newses = tbNewsService.getTopThree(ConfigUtil.getHomePageNews());
		List<TbNews> newsList1 = tbNewsService.getHangYeZiXuan();
		List<TbNews> newsList2 = new ArrayList<>();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		if (newsList1 != null && newsList1.size() > 8){
			newsList2.addAll(8,newsList1);
			newsList1.remove(newsList2);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("zixuanList1",newsList1);
		map.put("zixuanList2",newsList2);
		map.put("topNews",newses);
		map.put("phoneNumber",phoneNumber);
		modelAndView.setViewName("newsCenter");
		modelAndView.addObject("map",map);
		return modelAndView;
	}

	/**
	 * 新闻展示
	 * @return
     */
	@RequestMapping(value = "/{newsId}")
	public ModelAndView showNews(@PathVariable(value = "newsId") String newsId){
		ModelAndView modelAndView  = new ModelAndView();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		TbNews news = tbNewsService.get(newsId);
		news.setNewsTime(DateUtil.date2str(news.getCreateTime()));
		news.setPhoneNumber(phoneNumber);
		modelAndView.addObject("news",news);
		modelAndView.setViewName("newsDetail");
		return modelAndView;
	}

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