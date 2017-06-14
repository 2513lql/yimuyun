/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.common;

/**
 * Service层公用的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * @author ThinkGem
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int code = 0;
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(int code, String message) {
		this(message);
		this.code = code;
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
	public ServiceException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	public ServiceException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
