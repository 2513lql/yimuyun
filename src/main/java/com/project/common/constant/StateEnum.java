package com.project.common.constant;

/**
 * 结果
 */
public enum StateEnum {


	NORMAL("0", "正常"),

	DELETED("1", "删除");

	private String code;

	private String description;

	private StateEnum(String code, String description) {
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
		for (StateEnum result : StateEnum.values()) {
			if (code != null &&code .equals( result.getCode())) {
				return result.getDescription();
			}
		}
		return null;
	}

}
