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
        String rootUrl = url.substring(0, url.length() - 6);
        String wxUrl = rootUrl + "wxScan?url=" + url;
//        System.out.println(wxUrl);
        String APPID = "wx8209687dfe66ec4f";
        String APPSecret = "2d6e0c8c33f3b4784996616b1b39eee4";
        String url_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSecret;
        String access_token = null;
        String jsapi_ticket = null;
        AccessToken accessToken = new AccessToken();
        long time = System.currentTimeMillis();

        if (accessTokenService.select() == null) {
            try {
//                System.out.println(1);
                access_token = (String) JSON.parseObject(HttpClientUtil.httpGet(url_token)).get("access_token");
                String url_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";
                jsapi_ticket = (String) JSON.parseObject(HttpClientUtil.httpGet(url_ticket)).get("ticket");
                accessToken.setUpdateTime(time + "");
                accessToken.setAccessToken(access_token);
                accessToken.setJsapiTicket(jsapi_ticket);
                accessTokenService.insert(accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ((time - Long.parseLong(accessTokenService.select().getUpdateTime())) > 6600000) {
            try {
//                System.out.println(System.currentTimeMillis());
//                System.out.println(2);
                access_token = (String) JSON.parseObject(HttpClientUtil.httpGet(url_token)).get("access_token");
                String url_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";
                jsapi_ticket = (String) JSON.parseObject(HttpClientUtil.httpGet(url_ticket)).get("ticket");
                accessToken.setUpdateTime(time + "");
                accessToken.setAccessToken(access_token);
                accessToken.setJsapiTicket(jsapi_ticket);
                accessTokenService.update(accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//            System.out.println(3);
            accessToken = accessTokenService.select();
            jsapi_ticket = accessToken.getJsapiTicket();
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
//        String url="http://localhost:8081/mobile/logisticsReceiver/v1.0.0/qrCode/" + qrCode;
        if (qrCode.contains("?")) {
            qrCode = qrCode.split("=")[1];
        }
        String url="http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/qrCode/" + qrCode;
        JSONObject result = new JSONObject();
        try {
            result = JSON.parseObject(HttpClientUtil.httpGet(url)).getJSONObject("body");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
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
