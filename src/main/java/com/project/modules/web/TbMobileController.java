package com.project.modules.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.project.common.controller.ControllerException;
import com.project.common.service.ServiceException;
import com.project.common.utils.*;
import com.project.modules.entity.TbLeaveMessage;
import com.project.modules.service.TbLeaveMessageService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Xuan on 2017/6/21.
 */
@Controller
public class TbMobileController {
    @Autowired
    private TbLeaveMessageService tbLeaveMessageService;
    /**
     * @api /mobileTrace                1. 移动端追溯防伪查询
     * @apiName mobileTrace
     * @apiParam {String} traceCode		追溯序列号：不可空
     * @return
     */
    @RequestMapping("mobileTrace")
    public ModelAndView mobileTrace(String traceCode) {
        String url = "http://115.28.109.174:8383/yimu/trace/v1.0.0/traceCode/" + traceCode;
        JSONObject result = new JSONObject();
        try {
            result = JSON.parseObject(HttpClientUtil.httpGet(url)).getJSONObject("body");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mobile");
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    /**
     * 留言反馈
     * @return
     */
    @RequestMapping("leaveComments")
    public ModelAndView leaveComments(){
        ModelAndView modelAndView = new ModelAndView("mobileComments");
        return modelAndView;
    }

    @RequestMapping(value = "/mobile/message", produces = {"text/html;charset=UTF-8"})
    public ModelAndView leaveMessage(HttpServletRequest request, ServletRequest request1){
        String imgName = null;
        TbLeaveMessage leaveMessage = new TbLeaveMessage();
        List<FileItem> viewUrlList = new ArrayList();
        try{
            String imageDir = request.getSession().getServletContext().getRealPath("/")+"/upload/";
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
                    fieldValue = new String(fieldValue.getBytes("ISO8859-1"), "UTF-8");
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
//			if(leaveMessage.getProblemType() == null || "".equals(leaveMessage.getProblemType())){
//				throw new ControllerException("留言类型不能为空");
//			}
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
        }catch (ControllerException e){
        }catch (ServiceException e){
        }catch (Exception e){
        }
        return new ModelAndView("mobileComments");
    }
}
