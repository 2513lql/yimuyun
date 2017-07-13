package com.project.modules.web;

import com.alibaba.fastjson.JSON;
import com.project.common.utils.HttpClientUtil;
import com.project.common.utils.WXUtil;
import com.project.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Xuan on 2017/7/11.
 */
@Controller
@RequestMapping(value = "/logisticsReceiver")
public class LogisticsReceiverController extends BaseController {

    @RequestMapping(value = "signIn")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView("signIn");
        return modelAndView;
    }

    @RequestMapping(value = "noUser")
    public ModelAndView noUser() {
        ModelAndView modelAndView = new ModelAndView("signDeta");
        return modelAndView;
    }

    @RequestMapping(value = "wxScan")
    public ModelAndView wxScan(String url) {
        String APPID = "wx8209687dfe66ec4f";
        String APPSecret = "2d6e0c8c33f3b4784996616b1b39eee4";
        String url_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSecret;
        String access_token = null;
        String url_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";
        String jsapi_ticket = null;
        try {
            access_token = (String) JSON.parseObject(HttpClientUtil.httpGet(url_token)).get("access_token");
            jsapi_ticket = (String) JSON.parseObject(HttpClientUtil.httpGet(url_ticket)).get("ticket");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> ret = WXUtil.sign(jsapi_ticket, url);
        ModelAndView modelAndView = new ModelAndView("wxScan");
        modelAndView.addObject("timestamp", ret.get("timestamp"));
        modelAndView.addObject("nonceStr", ret.get("nonceStr"));
        modelAndView.addObject("signature", ret.get("signature"));
        return modelAndView;
    }

    @RequestMapping(value = "getPackingInfo")
    public ModelAndView getPackingInfo(String qrCode) {
        ModelAndView modelAndView = new ModelAndView("signDetail");
        return modelAndView;
    }
}
