package com.project.common.constant;

/**
 * 结果
 */
public enum OutDatedEnum {


	NORMAL("0", "正常"),

	OUT_DATED("1", "过期");

	private String code;

	private String description;

	private OutDatedEnum(String code, String description) {
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
		for (OutDatedEnum result : OutDatedEnum.values()) {
			if (code != null &&code .equals( result.getCode())) {
				return result.getDescription();
			}
		}
		return null;
	}

}
