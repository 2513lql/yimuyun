package com.project.common.constant;

/**
 * 结果
 */
public enum RegisterTypeEnum {


	QQ("0", "QQ注册"),

	WE_CHAT("1", "微信注册"),

	MOBILE("2", "手机注册");

	private String code;

	private String description;

	private RegisterTypeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static String getDescription(String code) {
		for (RegisterTypeEnum result : RegisterTypeEnum.values()) {
			if (code != null &&code .equals( result.getCode())) {
				return result.getDescription();
			}
		}
		return null;
	}

}
