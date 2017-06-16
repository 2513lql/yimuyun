/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.project.modules.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.config.Global;
import com.project.common.constant.ResultEnum;
import com.project.common.constant.StateEnum;
import com.project.common.controller.ControllerException;
import com.project.common.persistence.Page;
import com.project.common.service.ServiceException;
import com.project.common.utils.*;
import com.project.common.web.BaseController;
import com.project.common.web.HttpOutMessage;
import com.project.common.web.OutMessageUtils;
import com.project.modules.entity.TbApplyFarming;
import com.project.modules.entity.TbApplySlaughter;
import com.project.modules.entity.TbLeaveMessage;
import com.project.modules.service.TbApplySlaughterService;
import com.project.modules.service.TbLeaveMessageService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.modules.service.TbApplyFarmingService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 养殖单位申请Controller
 * @author LQL
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "/apply")
public class TbApplyFarmingController extends BaseController {

	@Autowired
	private TbApplyFarmingService tbApplyFarmingService;
	@Autowired
	private TbApplySlaughterService tbApplySlaughterService;
	@Autowired
	private TbLeaveMessageService tbLeaveMessageService;

	/**
	 * 养殖单位申请
	 * @param request
	 * @return
     */
	@ResponseBody
	@RequestMapping("/farming")
	public HttpOutMessage insertFarming(HttpServletRequest request){
		String imgName = null;
		TbApplyFarming applyFarming = new TbApplyFarming();
		List<FileItem> viewUrlList = new ArrayList();
		try{
			String imageDir = ConfigUtil.getUploadImageDir();
			if(imageDir == null){
				imageDir = request.getSession().getServletContext().getRealPath("/")+"/HeadImg/";   //头像目录
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(ConfigUtil.getMaxUploadSize());
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
			while (iter.hasNext())
			{
				FileItem item = (FileItem)iter.next();// 忽略其他不是文件域的所有表单信息
				if (!item.isFormField())
				{
					viewUrlList.add(item);
					//取出不是文件域的所有表单信息
				}else{
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					if("name".equals(fieldName)){
						applyFarming.setName(fieldValue);
					}
					if("scale".equals(fieldName)){
						applyFarming.setScale(fieldValue);
					}
					if ("type".equals(fieldName)){
						applyFarming.setType(fieldValue);
					}
					if ("telephoneNumber".equals(fieldName)){
						applyFarming.setTelephoneNumber(fieldValue);
					}
				}
			}
			if(applyFarming.getName() == null || "".equals(applyFarming.getName())){
				throw new ControllerException("养殖单位名称不能为空");
			}
			if (applyFarming.getScale() == null || "".equals(applyFarming.getScale())){
				throw new ControllerException("养殖规模不能为空");
			}
			if (applyFarming.getType() == null || "".equals(applyFarming.getScale())){
				throw new ControllerException("养殖类型不能为空");
			}
			if (applyFarming.getTelephoneNumber() == null || "".equals(applyFarming.getScale())){
				throw new ControllerException("联系电话不能为空");
			}

			StringBuffer viewUrlAppender = new StringBuffer();
			for (int i = 0 ; i < viewUrlList.size();i++){
				FileItem item = viewUrlList.get(i);
				String name = item.getName();//获取上传文件名,包括路径
				imgName = name.substring(name.lastIndexOf("\\")+1);//从全路径中提取文件名
				long size = item.getSize();
				if((imgName == null||imgName.equals("")) && size==0)
					continue;
				int point = imgName.indexOf(".");
				imgName = (IDGenUtil.generateFileName()+imgName.substring(point,imgName.length()));
				FileUtils.createParentDir(new File(imageDir));
				File fNew = new File(imageDir, imgName);
				fNew.createNewFile();
				item.write(fNew);
				viewUrlAppender.append(Constants.prefix_upload_url + imgName+ Constants.url_separator);
			}
			String viewUrlStr = viewUrlAppender.toString();
			if(viewUrlStr.endsWith(Constants.url_separator)){
				viewUrlStr = viewUrlStr.substring(0,viewUrlStr.length()-1);
			}
			String[] pictureUlrs = viewUrlStr.split(";");
			if (pictureUlrs == null || pictureUlrs.length == 0){
			}
			else if (pictureUlrs.length == 1){
				applyFarming.setPicture1(pictureUlrs[0]);
			}else if (pictureUlrs.length == 2){
				applyFarming.setPicture1(pictureUlrs[0]);
				applyFarming.setPicture2(pictureUlrs[1]);
			}else {
				applyFarming.setPicture1(pictureUlrs[0]);
				applyFarming.setPicture2(pictureUlrs[1]);
				applyFarming.setPicture3(pictureUlrs[2]);
			}
			applyFarming.setCreateTime(new Date());
			applyFarming.setUpdateTime(new Date());
			tbApplyFarmingService.save(applyFarming);
			return OutMessageUtils.buildOutMessage(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getDescription());
		}catch (ControllerException e){
			logger.error("新增养殖单位异常：{}",e);
			return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),e.getMessage());
		}catch (ServiceException e){
			logger.error("新增养殖单位异常：{}",e);
			return OutMessageUtils.buildOutMessage(e.getCode(),e.getMessage());
		}catch (Exception e){
			logger.error("新增养殖单位异常，服务器异常:{}",e);
			return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),"新增标记点，服务器异常："+e.getMessage());
		}
	}

	/**
	 * 屠宰企业申请
	 * @param applySlaughter
	 * @return
     */
	@ResponseBody
	@RequestMapping(value = "/slaughter")
	public com.project.common.HttpOutMessage applySlaughter(TbApplySlaughter applySlaughter){
		try {
			if (applySlaughter.getEnterpriseType() == null || "".equals(applySlaughter.getEnterpriseType())) {
				throw new com.project.common.ControllerException("企业类型不能为空");
			}
			if (applySlaughter.getName() == null || "".equals(applySlaughter.getName())){
				throw new com.project.common.ControllerException("企业名称不能为空");
			}
			if (applySlaughter.getAddress() == null || "".equals(applySlaughter.getName())){
				throw  new com.project.common.ControllerException("企业地址不能为空");
			}
			if (applySlaughter.getTelephoneNumber() == null || "".equals(applySlaughter.getName())){
				throw new com.project.common.ControllerException("联系电话不能为空");
			}
			if (applySlaughter.getContact() == null || "".equals(applySlaughter.getContact())){
				throw new com.project.common.ControllerException("联系人不能为空");
			}
			Date date = new Date();
			applySlaughter.setCreateTime(date);
			applySlaughter.setUpdateTime(date);
			tbApplySlaughterService.save(applySlaughter);
			return com.project.common.OutMessageUtils.buildOutMessage(com.project.common.ResultEnum.SUCCESS.getCode(), com.project.common.ResultEnum.SUCCESS.getDescription());
		}catch (com.project.common.ControllerException e){
			logger.error("屠宰加工或餐饮企业申请添加一场");
			return com.project.common.OutMessageUtils.buildOutMessage(com.project.common.ResultEnum.ERROR.getCode(),e.getMessage());
		}catch (Exception e){
			logger.error("服务器异常");
			return com.project.common.OutMessageUtils.buildOutMessage(com.project.common.ResultEnum.ERROR.getCode(),"服务器异常");
		}
	}


	@ResponseBody
	@RequestMapping("/message")
	public HttpOutMessage leaveMessage(HttpServletRequest request){
		String imgName = null;
		TbLeaveMessage leaveMessage = new TbLeaveMessage();
		List<FileItem> viewUrlList = new ArrayList();
		try{
			String imageDir = ConfigUtil.getUploadImageDir();
			if(imageDir == null){
				imageDir = request.getSession().getServletContext().getRealPath("/")+"/HeadImg/";   //头像目录
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(ConfigUtil.getMaxUploadSize());
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
			while (iter.hasNext())
			{
				FileItem item = (FileItem)iter.next();// 忽略其他不是文件域的所有表单信息
				if (!item.isFormField())
				{
					viewUrlList.add(item);
					//取出不是文件域的所有表单信息
				}else{
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					if("problemType".equals(fieldName)){
						leaveMessage.setProblemType(fieldValue);
					}
					if("describe".equals(fieldName)){
						leaveMessage.setDescribe(fieldValue);
					}
					if ("contact".equals(fieldName)){
						leaveMessage.setContact(fieldValue);
					}
				}
			}
			if(leaveMessage.getProblemType() == null || "".equals(leaveMessage.getProblemType())){
				throw new ControllerException("留言类型不能为空");
			}
			if (leaveMessage.getDescribe() == null || "".equals(leaveMessage.getDescribe())){
				throw new ControllerException("描述不能为空");
			}
			if (leaveMessage.getContact() == null || "".equals(leaveMessage.getContact())){
				throw new ControllerException("联系方式不能为空");
			}

			StringBuffer viewUrlAppender = new StringBuffer();
			for (int i = 0 ; i < viewUrlList.size();i++){
				FileItem item = viewUrlList.get(i);
				String name = item.getName();//获取上传文件名,包括路径
				imgName = name.substring(name.lastIndexOf("\\")+1);//从全路径中提取文件名
				long size = item.getSize();
				if((imgName == null||imgName.equals("")) && size==0)
					continue;
				int point = imgName.indexOf(".");
				imgName = (IDGenUtil.generateFileName()+imgName.substring(point,imgName.length()));
				FileUtils.createParentDir(new File(imageDir));
				File fNew = new File(imageDir, imgName);
				fNew.createNewFile();
				item.write(fNew);
				viewUrlAppender.append(Constants.prefix_upload_url + imgName+ Constants.url_separator);
			}
			String viewUrlStr = viewUrlAppender.toString();
			if(viewUrlStr.endsWith(Constants.url_separator)){
				viewUrlStr = viewUrlStr.substring(0,viewUrlStr.length()-1);
			}
			String[] pictureUlrs = viewUrlStr.split(";");
			if (pictureUlrs == null || pictureUlrs.length == 0){
			}
			else if (pictureUlrs.length == 1){
				leaveMessage.setPicture1(pictureUlrs[0]);
			}else if (pictureUlrs.length == 2){
				leaveMessage.setPicture1(pictureUlrs[0]);
				leaveMessage.setPicture2(pictureUlrs[1]);
			}else {
				leaveMessage.setPicture1(pictureUlrs[0]);
				leaveMessage.setPicture2(pictureUlrs[1]);
				leaveMessage.setPicture3(pictureUlrs[2]);
			}
			Date date = new Date();
			leaveMessage.setCreateTime(date);
			leaveMessage.setUpdateTime(date);
			tbLeaveMessageService.save(leaveMessage);
			return OutMessageUtils.buildOutMessage(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getDescription());
		}catch (ControllerException e){
			logger.error("添加留言异常：{1}",e);
			return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),e.getMessage());
		}catch (ServiceException e){
			logger.error("添加留言异常：{2",e);
			return OutMessageUtils.buildOutMessage(e.getCode(),e.getMessage());
		}catch (Exception e){
			logger.error("添加留言异常:{3}",e);
			return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),"添加留言异常，服务器异常："+e.getMessage());
		}
	}

	@ModelAttribute
	public TbApplyFarming get(@RequestParam(required=false) String id) {
		TbApplyFarming entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbApplyFarmingService.get(id);
		}
		if (entity == null){
			entity = new TbApplyFarming();
		}
		return entity;
	}
	
	@RequiresPermissions("modules:tbApplyFarming:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbApplyFarming tbApplyFarming, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbApplyFarming> page = tbApplyFarmingService.findPage(new Page<TbApplyFarming>(request, response), tbApplyFarming);
		model.addAttribute("page", page);
		return "modules/modules/tbApplyFarmingList";
	}

	@RequiresPermissions("modules:tbApplyFarming:view")
	@RequestMapping(value = "form")
	public String form(TbApplyFarming tbApplyFarming, Model model) {
		model.addAttribute("tbApplyFarming", tbApplyFarming);
		return "modules/modules/tbApplyFarmingForm";
	}

	@RequiresPermissions("modules:tbApplyFarming:edit")
	@RequestMapping(value = "save")
	public String save(TbApplyFarming tbApplyFarming, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbApplyFarming)){
			return form(tbApplyFarming, model);
		}
		tbApplyFarmingService.save(tbApplyFarming);
		addMessage(redirectAttributes, "保存养殖单位申请成功");
		return "redirect:"+ Global.getAdminPath()+"/modules/tbApplyFarming/?repage";
	}
	
	@RequiresPermissions("modules:tbApplyFarming:edit")
	@RequestMapping(value = "delete")
	public String delete(TbApplyFarming tbApplyFarming, RedirectAttributes redirectAttributes) {
		tbApplyFarmingService.delete(tbApplyFarming);
		addMessage(redirectAttributes, "删除养殖单位申请成功");
		return "redirect:"+Global.getAdminPath()+"/modules/tbApplyFarming/?repage";
	}



}