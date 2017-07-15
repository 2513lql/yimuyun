package com.project.modules.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.project.common.utils.HttpClientUtil;
import com.project.common.utils.WXUtil;
import com.project.common.web.BaseController;
import com.project.modules.entity.AccessToken;
import com.project.modules.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by Xuan on 2017/7/11.
 */
@Controller
@RequestMapping(value = "/logisticsReceiver")
public class LogisticsReceiverController extends BaseController {
    @Autowired
    AccessTokenService accessTokenService;

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
        String wxUrl="http://ymweixin.gzkuang.com/yimuyun/logisticsReceiver/wxScan?url=http://ymweixin.gzkuang.com/yimuyun/logisticsReceiver/signIn";
        String APPID = "wx8209687dfe66ec4f";
        String APPSecret = "2d6e0c8c33f3b4784996616b1b39eee4";
        String url_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSecret;
        String access_token = null;
        String jsapi_ticket = null;
        AccessToken accessToken = new AccessToken();
        Date date = new Date();
        if (accessTokenService.select() == null) {
            try {
                access_token = (String) JSON.parseObject(HttpClientUtil.httpGet(url_token)).get("access_token");
                accessToken.setUpdateTime(date);
                accessToken.setAccessToken(access_token);
                accessTokenService.insert(accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (date.getTime() - accessTokenService.select().getUpdateTime().getTime() > 6600000) {
            try {
                access_token = (String) JSON.parseObject(HttpClientUtil.httpGet(url_token)).get("access_token");
                accessToken.setUpdateTime(date);
                accessToken.setAccessToken(access_token);
                accessTokenService.update(accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            accessToken = accessTokenService.select();
        }
        try {
            String url_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";
            jsapi_ticket = (String) JSON.parseObject(HttpClientUtil.httpGet(url_ticket)).get("ticket");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> ret = WXUtil.sign(jsapi_ticket, wxUrl);
        ModelAndView modelAndView = new ModelAndView("wxScan");
        modelAndView.addObject("timestamp", ret.get("timestamp"));
        modelAndView.addObject("nonceStr", ret.get("nonceStr"));
        modelAndView.addObject("signature", ret.get("signature"));
        return modelAndView;
    }

    @RequestMapping(value = "getPackingInfo")
    public ModelAndView getPackingInfo(String qrCode) {
        String url="http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/qrCode/" + qrCode;
        JSONObject result = new JSONObject();
        try {
            result = JSON.parseObject(HttpClientUtil.httpGet(url)).getJSONObject("body");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("signDetail");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @RequestMapping(value = "receive")
    public ModelAndView receive() {
        ModelAndView modelAndView = new ModelAndView("receiveSuccess");
        return modelAndView;
    }
}
