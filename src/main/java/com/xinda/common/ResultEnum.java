package com.xinda.common;

public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 错误
     */
    ERROR(1, "error");

    private int code;

    private String description;

    private ResultEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getDescription(int code) {
        for (ResultEnum result : ResultEnum.values()) {
            if (code == result.getCode()) {
                return result.getDescription();
            }
        }
        return null;
    }

}
