package com.project.common.utils;

import com.project.common.service.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);


	public static Integer getDefaultPageSize(){
		String pageSize = PropertiesUtil.getInstance("traceback.properties").getText("page.pageSize");
		if (StringUtils.isNoneBlank(pageSize)) {
			return Integer.parseInt(pageSize);
		}
		logger.error("默认pageSize为空");
		return 20;
	}

	/**
	 *新闻置顶
	 * @return
     */
	public static String getNewsIsTop(){
		String istop = PropertiesUtil.getInstance("traceback.properties").getText("news.top");
		if (StringUtils.isNoneBlank(istop)) {
			return istop;
		}
		logger.error("新闻置顶配置为空");
		return null;
	}

	public static String getUploadImageDir(){
		String headImageDir = PropertiesUtil.getInstance("traceback.properties").getText("img.upload.url.head");
		if (StringUtils.isNoneBlank(headImageDir)) {
			return headImageDir;
		}
		logger.error("上传文件夹配置为空");
		return null;
	}

	public static Long getMaxUploadSize(){
		String size = PropertiesUtil.getInstance("traceback.properties").getText("web.maxUploadSize");
		if (StringUtils.isNoneBlank(size)) {
			return Long.parseLong(size);
		}
		logger.error("上传文件夹大小配置为空");
		return 1*1024*1024L;
	}

	public static String getHomePageNews(){
		String homeNewsLocation = PropertiesUtil.getInstance("traceback.properties").getText("home.news.location");
		if (StringUtils.isNoneBlank(homeNewsLocation)) {
			return homeNewsLocation;
		}
		logger.error("首页新闻为空");
		return null;
	}

	public static String getCompanyNewsLocation(){
		String companyNewsLocation = PropertiesUtil.getInstance("traceback.properties").getText("company.news.location");
		if (StringUtils.isNoneBlank(companyNewsLocation)) {
			return companyNewsLocation;
		}
		logger.error("公司新闻为空");
		return null;
	}

	public static String getIndustryNewsLocation(){
		String industryNewsLocation = PropertiesUtil.getInstance("traceback.properties").getText("industry.news.location");
		if (StringUtils.isNoneBlank(industryNewsLocation)) {
			return industryNewsLocation;
		}
		logger.error("行业快讯新闻为空");
		return null;
	}

	public static String getMuslimCultureNewsLocation(){
		String muslimCultureNewsLocation = PropertiesUtil.getInstance("traceback.properties").getText("muslim.culture.news.location");
		if (StringUtils.isNoneBlank(muslimCultureNewsLocation)) {
			return muslimCultureNewsLocation;
		}
		logger.error("清真文化为空");
		return null;
	}

	public static String getDevelopmentHistoryNewsLocation(){
		String levelopmentHistoryNewsLocation = PropertiesUtil.getInstance("traceback.properties").getText("development.history.news.location");
		if (StringUtils.isNoneBlank(levelopmentHistoryNewsLocation)) {
			return levelopmentHistoryNewsLocation;
		}
		logger.error("首页新闻为空");
		return null;
	}

	public static String getRequestURLHead(){
		String urlHead = PropertiesUtil.getInstance("traceback.properties").getText("request.url.head");
		if (StringUtils.isNoneBlank(urlHead)) {
			return urlHead;
		}
		logger.error("请求路径头部不能为空");
		return null;
	}

	public static String getAdminUrlHead(){
		String urlHead = PropertiesUtil.getInstance("traceback.properties").getText("admin.picture.url.head");
		if (StringUtils.isNoneBlank(urlHead)) {
			return urlHead;
		}
		logger.error("请求路径头部不能为空");
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getHomePageNews());
	}
}
