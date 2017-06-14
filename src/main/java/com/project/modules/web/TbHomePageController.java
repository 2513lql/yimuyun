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
import com.project.modules.service.TbNewsService;
import com.sun.javafx.collections.MappingChange;
import org.apache.poi.ss.formula.functions.Mode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 首页信息Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "/")
public class TbHomePageController extends BaseController {

	@Autowired
	private TbHomePageService tbHomePageService;
	@Autowired
	private TbNewsService tbNewsService;

	@RequestMapping(value={"","home"})
	public ModelAndView homePage(){
		TbHomePage homePage = tbHomePageService.getHomePage();
		String homeLocation  = ConfigUtil.getHomePageNews();
		List<TbNews> homeNews = tbNewsService.getTopThree(homeLocation);
		Map<String,Object> map = new HashMap<>();
		map.put("homeNews",homeNews);
		map.put("homePage",homePage);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("map",map);
		return modelAndView;
	}

	/**
	 * 追溯防僞查詢
	 * @return
     */
	@RequestMapping("trace")
	public ModelAndView traceQuery(){
		ModelAndView modelAndView = new ModelAndView();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		modelAndView.addObject("phoneNumber",phoneNumber);
		modelAndView.setViewName("traceQuery");
		return modelAndView;
	}

	/**
	 * 清真文化
	 * @return
     */
	@RequestMapping("muslim")
	public ModelAndView muslimCulture(){
		ModelAndView modelAndView = new ModelAndView();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		TbNews tbNews = tbNewsService.getMuslimCultrue();
		if (tbNews.getCreateTime() != null){
			tbNews.setNewsTime(DateUtil.date2str(tbNews.getCreateTime()));
		}
		tbNews.setPhoneNumber(phoneNumber);
		modelAndView.addObject("news",tbNews);
		modelAndView.setViewName("muslimCulture");
		return modelAndView;
	}

	/**
	 *关于我们
	 * @return
     */
	@RequestMapping("about")
	public ModelAndView aboutUs(){
		ModelAndView modelAndView = new ModelAndView();
		//公司发展历程新闻
		List<TbNews> companyTopNews = tbNewsService.getTopThree(ConfigUtil.getDevelopmentHistoryNewsLocation());
		List<TbNews> companyNews = tbNewsService.getCompanyDevelopNews(); //公司发展历程
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		Map<String,Object> map = new HashMap<>();
		map.put("phoneNumber",phoneNumber);
		map.put("companyTopNews",companyTopNews);
		map.put("companyNews",companyNews);
		modelAndView.addObject("map",map);
		modelAndView.setViewName("aboutUs");
		return modelAndView;
	}

	/**
	 *关于我们
	 * @return
	 */
	@RequestMapping("join")
	public ModelAndView joinUs(){
		ModelAndView modelAndView = new ModelAndView();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		modelAndView.addObject("phoneNumber",phoneNumber);
		modelAndView.setViewName("joinUs");
		return modelAndView;
	}

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