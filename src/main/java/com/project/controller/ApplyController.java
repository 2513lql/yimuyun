package com.project.controller;

import com.project.common.ControllerException;
import com.project.common.HttpOutMessage;
import com.project.common.OutMessageUtils;
import com.project.common.ResultEnum;
import com.xinda.model.ApplySlaughter;
import com.project.service.LApplySlaughterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by LQL on 2017/6/10.
 */
//@Controller
//@RequestMapping("/apply")
public class ApplyController {

    private static final Logger logger = LoggerFactory.getLogger(ControllerException.class);

    @Autowired
    private LApplySlaughterService lApplySlaughterService;


    @RequestMapping("/test")
    public ModelAndView test(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * @api {post} /apply/slaughter  1.屠宰加工或者餐饮企业申请
     * @apiVersion 1.0.0
     * @apiName	 applySlaughter
     * @apiGroup	Apply
     * @apiDescription 屠宰加工或者餐饮企业申请
     * @apiParam {String} enterpriseType                        企业类型 （不可为空）
     * @apiParam {String} name                                  企业名称
     * @apiParam {String} address                               企业地址
     * @apiParam {String} telephoneNumber 		                联系电话
     * @apiParam {String} contact		                        联系人
     * @apiSuccessExample Success-Response:
     *{
     *    "code": 0,
     *    "content": {
     *        "pageNo": 1,			//当前页码
     *        "pageSize": 20,		//每页大小
     *        "count": 5,			//总条数
     *        "list": [
     *            {
     *                "id": "b629f4379e3447a59d09849002595724",
     *                "createTime": 1489807360000,                    //活动创建时间戳
     *                "title": "测试活动",                             //活动标题
     *                "introduction": "这是一个测试活动\n",             //活动介绍
     *                "publisher": {                                  //活动发起人信息
     *                   "id": "e2f835b965e34b2fb8d6cbc22378f55a",
     *                   "avatar": "http://q.qlogo.cn/qqapp/1104296289/26C346A929894708488B33195AF1D297/100",
     *                    "nickName": "Apoptoxin"
     *                 },
     *                "isOutDate": "0",                               //活动是否过期，0 没有 1 有
     *                "attenderCount": 0,                             //参加人数
     *                "startTimeStamp": 1489766000,                   //活动开始时间戳
     *                "createTimestamp": 1489807360000,
     *                "endTimestamp": 1490198000,                     //活动结束时间戳
     *                 "banner": "http://115.28.109.174:8282/image/201703186c08af.png"     //活动封面图片
     *            }
     *        ]
     *    }
     *}
     */
    @ResponseBody
    @RequestMapping(value = "/slaughter")
    public HttpOutMessage applySlaughter(ApplySlaughter applySlaughter, HttpServletRequest request){
        try {
            System.out.println(request.getParameter("enterpriseType"));
            applySlaughter.setEnterpriseType(request.getParameter("enterpriseType"));
            applySlaughter.setName(request.getParameter("name"));
            applySlaughter.setAddress(request.getParameter("address"));
            applySlaughter.setTelephoneNumber(request.getParameter("telephoneNumber"));
            applySlaughter.setContact(request.getParameter("contact"));
            if (applySlaughter.getEnterpriseType() == null || "".equals(applySlaughter.getEnterpriseType())) {
                throw new ControllerException("企业类型不能为空");
            }
            if (applySlaughter.getName() == null || "".equals(applySlaughter.getName())){
                throw new ControllerException("企业名称不能为空");
            }
            if (applySlaughter.getAddress() == null || "".equals(applySlaughter.getName())){
                throw  new ControllerException("企业地址不能为空");
            }
            if (applySlaughter.getTelephoneNumber() == null || "".equals(applySlaughter.getName())){
                throw new ControllerException("联系电话不能为空");
            }
            if (applySlaughter.getContact() == null || "".equals(applySlaughter.getContact())){
                throw new ControllerException("联系人不能为空");
            }
            Date date = new Date();
            applySlaughter.setCreateTime(date);
            applySlaughter.setUpdateTime(date);
            lApplySlaughterService.insert(applySlaughter);
            return OutMessageUtils.buildOutMessage(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getDescription());
        }catch (ControllerException e){
            logger.error("屠宰加工或餐饮企业申请添加一场");
            return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),e.getMessage());
        }catch (Exception e){
            logger.error("服务器异常");
            return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),"服务器异常");
        }

    }


}
