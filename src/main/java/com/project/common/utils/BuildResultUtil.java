package com.project.common.utils;


import com.project.common.constant.ResultEnum;
import com.project.common.web.HttpOutMessage;

public class BuildResultUtil {

	/**
	 * <p>
	 * 构建输出结果对象
	 * </p>
	 * 
	 * @param code
	 *            返回码
	 * @param content
	 *            返回信息
	 * @return 输出结果对象
	 */
	public static final HttpOutMessage buildOutResult(int code, Object content) {
		HttpOutMessage result = new HttpOutMessage();
		result.setCode(code);
		result.setContent(content);
		return result;
	}

	/**
	 * 构建输出结果对象
	 * 
	 * @param code
	 *            返回码
	 * @return
	 */
	public static final HttpOutMessage buildOutResult(int code) {
		HttpOutMessage result = new HttpOutMessage();
		result.setCode(code);
		result.setContent(ResultEnum.getDescription(code));
		return result;
	}

	/**
	 * 构建输出结果对象
	 * 
	 * @param resultEnum
	 * 返回码
	 * @return
	 */
	public static final HttpOutMessage buildOutResult(ResultEnum resultEnum) {
		HttpOutMessage result = new HttpOutMessage();
		result.setCode(resultEnum.getCode());
		result.setContent("");
		return result;
	}

	/**
	 * 构建输出结果对象
	 * 
	 * @param resultEnum 返回码
	 * @param obj
	 * @return
	 */
	public static final HttpOutMessage buildOutResult(ResultEnum resultEnum, Object obj) {
		HttpOutMessage result = new HttpOutMessage();
		result.setCode(resultEnum.getCode());
		result.setContent(obj);
		return result;
	}
}
