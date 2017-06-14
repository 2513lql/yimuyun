package com.project.common.utils;

import com.project.common.service.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);


	public static String getUploadImageDir(){
		String headImageDir = PropertiesUtil.getInstance("walkman.properties").getText("head.image.dir");
		if (StringUtils.isNoneBlank(headImageDir)) {
			return headImageDir;
		}
		logger.error("上传文件夹配置为空");
		return null;
	}
	public static Long getMaxUploadSize(){
		String size = PropertiesUtil.getInstance("walkman.properties").getText("web.maxUploadSize");
		if (StringUtils.isNoneBlank(size)) {
			return Long.parseLong(size);
		}
		logger.error("上传文件夹大小配置为空");
		return 1*1024*1024L;
	}
	public static Integer getDefaultNearbyDistance(){
		String distance = PropertiesUtil.getInstance("walkman.properties").getText("default.nearby.distance");
		if (StringUtils.isNoneBlank(distance)) {
			return Integer.parseInt(distance);
		}
		logger.error("默认附近距离配置为空");
		return 5000;
	}

	public static Integer getRoadConditionDistance(){
		String distance = PropertiesUtil.getInstance("walkman.properties").getText("default.road.condition.distance");
		if (StringUtils.isNoneBlank(distance)) {
			return Integer.parseInt(distance);
		}
		logger.error("默认附近距离配置为空");
		return 1000;
	}

	public static String getUploadFileUrl(){
		String url = PropertiesUtil.getInstance("walkman.properties").getText("upload.file.url");
		if (StringUtils.isBlank(url)) {
			throw new ServiceException("upload.file.url配置为空");
		}
		return url;
	}
	public static Integer getDefaultPageSize(){
		String pageSize = PropertiesUtil.getInstance("walkman.properties").getText("page.pageSize");
		if (StringUtils.isNoneBlank(pageSize)) {
			return Integer.parseInt(pageSize);
		}
		logger.error("默认pageSize为空");
		return 20;
	}
	public static double getWalkMoneyAndScoreRadio(){
		String radio = PropertiesUtil.getInstance("walkman.properties").getText("walk_money.to.score.radio");
		if (StringUtils.isNoneBlank(radio)) {
			return Double.parseDouble(radio);
		}
		logger.error("默认pageSize为空");
		return 20;
	}
	public static String getWeaterUrl(){
		String weatherUrl = PropertiesUtil.getInstance("walkman.properties").getText("weather.url");
		if (StringUtils.isNoneBlank(weatherUrl)) {
			return weatherUrl;
		}
		logger.error("天气预报URL配置为空");
		throw new ServiceException("天气预报URL配置为空");
	}


	public static int getWalkRecordScore(){
		String walkRecordScore = PropertiesUtil.getInstance("walkman.properties").getText("walk.record.score");
		if (StringUtils.isNoneBlank(walkRecordScore)) {
			return Integer.parseInt(walkRecordScore);
		}
		logger.error("步行初始分数为空");
		throw new ServiceException("步行初始分数为空");
	}

	public static void main(String[] args) {
		System.out.println(getUploadImageDir());
	}
}
