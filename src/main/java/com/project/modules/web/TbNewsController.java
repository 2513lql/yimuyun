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
import com.project.common.web.HttpOutMessage;
import com.project.common.web.OutMessageUtils;
import com.project.modules.entity.TbHomePage;
import com.project.modules.entity.TbNews;
import com.project.modules.service.TbHomePageService;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.formula.functions.Mode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
		ModelAndView modelAndView = new ModelAndView();
		List<TbNews> newses = tbNewsService.getTopThree(ConfigUtil.getCompanyNewsLocation());
		List<TbNews> newsList1 = tbNewsService.getHangYeZiXuan();
		List<TbNews> newsList2 = new ArrayList<>();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		if (newsList1 != null && newsList1.size() > 8){
			for (int i = 8; i < newsList1.size();){
				TbNews tbNews = newsList1.remove(i);
				newsList2.add(tbNews);
			}
		}
		Map<String,Object> map = new HashMap<>();
        for (TbNews news : newsList1){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
            news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
        }
        for (TbNews news : newsList2){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
            news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
        }
		for (TbNews news : newses){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
		}
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
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
		ModelAndView modelAndView  = new ModelAndView();
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		TbNews news = tbNewsService.get(newsId);
		news.setNewsTime(DateUtil.date2str(news.getCreateTime()));
		news.setPhoneNumber(phoneNumber);
		if (news.getPicture() != null){
			news.setPicture(adminPictureHead + news.getPicture());
		}
		modelAndView.addObject("news",news);
		modelAndView.setViewName("newsDetail");
		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView newsList(){
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
		int pageNo = 1;
		int pageSize = ConfigUtil.getDefaultPageSize();
		ModelAndView modelAndView = new ModelAndView();
		String newsType = ConfigUtil.getCompanyNewsLocation();
		TbNews tbNews = new TbNews();
        tbNews.setShowLocation(newsType);
		Page<TbNews> params = new Page<TbNews>(pageNo, pageSize);
		params.setOrderBy("createTime desc");
		Page<TbNews> page = tbNewsService.findPage(params,tbNews);
        String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
        int totalCount = tbNewsService.getTotalCount(newsType);
        int totalPage =(int) Math.ceil((totalCount * 1.0) / pageSize);
        Map<String,Object> map = new HashedMap();
        map.put("phoneNumber",phoneNumber);
        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        if (page.getList().size() % 3 == 0){ //如果是3的整数倍，则不加</div>
            map.put("isThree","1");
        }else {
            map.put("isThree","0");
        }
		for (TbNews news : page.getList()){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
		}
        map.put("page",page.getList());
		modelAndView.setViewName("newsList");
		modelAndView.addObject("map",map);
		return modelAndView;
	}


	/**
	 * 行业资讯更多
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping(value = "/more")
	public ModelAndView newsMore(ModelAndView modelAndView){
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
		int pageNo = 1;
		int pageSize = ConfigUtil.getIndustryPageSize();
		String newsType = ConfigUtil.getIndustryNewsLocation();
		TbNews tbNews = new TbNews();
		tbNews.setShowLocation(newsType);
		Page<TbNews> params = new Page<TbNews>(pageNo, pageSize);
		params.setOrderBy("createTime desc");
		Page<TbNews> page = tbNewsService.findPage(params,tbNews);
		String phoneNumber = tbHomePageService.getHomePage().getTelephoneNumber();
		int totalCount = tbNewsService.getTotalCount(newsType);
		int totalPage =(int) Math.ceil((totalCount * 1.0) / pageSize);
		Map<String,Object> map = new HashedMap();
		map.put("phoneNumber",phoneNumber);
		map.put("totalCount",totalCount);
		map.put("totalPage",totalPage);

		List<TbNews> newsList1 = page.getList();
		List<TbNews> newsList2 = new ArrayList<>();
		if (newsList1 != null && newsList1.size() > 8){
			for (int i = 8; i < newsList1.size();){
				TbNews tmp = newsList1.remove(i);
				newsList2.add(tmp);
			}
		}
		for (TbNews news : newsList1){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
			news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
		}
		for (TbNews news : newsList2){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
			news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
		}


		map.put("zixuanList1",newsList1);
		map.put("zixuanList2",newsList2);
//		map.put("page",page.getList());
		modelAndView.setViewName("newsMore");
		modelAndView.addObject("map",map);
		return modelAndView;
	}


	/**
	 * 行业资讯分页
	 * @param pageNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/morePage")
	public Map<String,Object> newsMorePage(Integer pageNo){
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
		if (pageNo == null || pageNo.equals("")){
			pageNo = 1;
		}
		int pageSize = ConfigUtil.getIndustryPageSize();
		String newsType = ConfigUtil.getIndustryNewsLocation();
		TbNews tbNews = new TbNews();
		tbNews.setShowLocation(newsType);
		Page<TbNews> params = new Page<TbNews>(pageNo, pageSize);
		params.setOrderBy("createTime desc");
		Page<TbNews> page = tbNewsService.findPage(params,tbNews);
		int totalCount = tbNewsService.getTotalCount(newsType);
		int totalPage =(int) Math.ceil((totalCount * 1.0) / pageSize);
		Map<String,Object> map = new HashedMap();
		map.put("totalCount",totalCount);
		map.put("totalPage",totalPage);

		List<TbNews> newsList1 = page.getList();
		List<TbNews> newsList2 = new ArrayList<>();
		if (newsList1 != null && newsList1.size() > 8){
			for (int i = 8; i < newsList1.size();){
				TbNews tmp = newsList1.remove(i);
				newsList2.add(tmp);
			}
		}
		for (TbNews news : newsList1){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
			news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
		}
		for (TbNews news : newsList2){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
			news.setNewsTime(DateUtil.date2shortStr(news.getCreateTime()));
		}
		map.put("zixuanList1",newsList1);
		map.put("zixuanList2",newsList2);
		return map;
	}

    /**
     * 分页查询新闻
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page")
    public Map<String,Object> getPageList(Integer pageNo){
		String adminPictureHead = ConfigUtil.getAdminUrlHead();
        if (pageNo == null || pageNo.equals("")){
            pageNo = 1;
        }
        int pageSize = ConfigUtil.getDefaultPageSize();
        TbNews tbNews = new TbNews();
        tbNews.setShowLocation(ConfigUtil.getCompanyNewsLocation());
        Page<TbNews> params = new Page<TbNews>(pageNo, pageSize);
        params.setOrderBy("createTime desc");
        Page<TbNews> page = tbNewsService.findPage(params,tbNews);
		String newsType = ConfigUtil.getCompanyNewsLocation();
        int totalCount = tbNewsService.getTotalCount(newsType);
        int totalPage =(int) Math.ceil((totalCount * 1.0) / pageSize);
        Map<String,Object> map = new HashedMap();
//        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        if (page.getList().size() % 3 == 0){ //如果是3的整数倍，则不加</div>
            map.put("isThree","1");
        }else {
            map.put("isThree","0");
        }
		for (TbNews news : page.getList()){
			if (news.getPicture() != null){
				news.setPicture(adminPictureHead + news.getPicture());
			}
		}
        map.put("page",page.getList());
        return map;
    }

//	@ResponseBody
//	@RequestMapping(value = "/list")
//	public HttpOutMessage newsList(){
//		int pageNo = 1;
//		int pageSize = ConfigUtil.getDefaultPageSize();
//		ModelAndView modelAndView = new ModelAndView();
//		TbNews tbNews = new TbNews();
//		Page<TbNews> params = new Page<TbNews>(pageNo, pageSize);
//		params.setOrderBy("createTime desc");
//		Page<TbNews> page = tbNewsService.findPage(params,tbNews);
//		modelAndView.setViewName("newsList");
//		modelAndView.addObject("page",page.getList());
//		return OutMessageUtils.buildOutMessage(1,page.getList());
//	}

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
	
//	@RequiresPermissions("modules:tbNews:view")
//	@RequestMapping(value = {"list", ""})
//	public String list(TbNews tbNews, HttpServletRequest request, HttpServletResponse response, Model model) {
//		Page<TbNews> page = tbNewsService.findPage(new Page<TbNews>(request, response), tbNews);
//		model.addAttribute("page", page);
//		return "modules/modules/tbNewsList";
//	}

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