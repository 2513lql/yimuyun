package com.project.modules.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.project.common.utils.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Xuan on 2017/6/21.
 */
@Controller
public class TbMobileController {

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

}
