/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.common.controller;

/**
 * Service层公用的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * @author ThinkGem
 */
public class ControllerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControllerException() {
		super();
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}
}
