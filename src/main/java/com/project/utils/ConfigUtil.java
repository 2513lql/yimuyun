package com.project.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

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
	public static void main(String[] args) {
		System.out.println(getHomePageNews());
	}
}
