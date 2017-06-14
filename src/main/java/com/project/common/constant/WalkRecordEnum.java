package com.project.common.constant;

/**
 * 结果
 */
public enum WalkRecordEnum {


	PRIVATE("0", "私有"),

	PUBLIC("1", "公开");

	private String code;

	private String description;

	private WalkRecordEnum(String code, String description) {
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
		for (WalkRecordEnum result : WalkRecordEnum.values()) {
			if (code != null &&code .equals( result.getCode())) {
				return result.getDescription();
			}
		}
		return null;
	}

}
