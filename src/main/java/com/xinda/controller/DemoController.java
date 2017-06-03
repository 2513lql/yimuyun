package com.xinda.controller;

import com.xinda.common.ControllerException;
import com.xinda.common.HttpOutMessage;
import com.xinda.common.OutMessageUtils;
import com.xinda.common.ResultEnum;
import com.xinda.service.DemoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by antong on 17/4/24.
 */
@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(ControllerException.class);

    @Autowired
    private DemoManager demoManager;

    @RequestMapping("/test")
    public ModelAndView test() {
        Map map = new HashMap<>();
        map.put("a", demoManager.test());
        ModelAndView modelAndView = new ModelAndView();
        return new ModelAndView("a", map);
    }

    @RequestMapping("/test1")
    @ResponseBody
    public HttpOutMessage test1() {
        try {
            return OutMessageUtils.buildOutMessage(ResultEnum.SUCCESS.getCode(), demoManager.test());
        }catch (ControllerException e){
            logger.error("参数异常",e);
            return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),e.getMessage());
        }catch (Exception e){
            return OutMessageUtils.buildOutMessage(ResultEnum.ERROR.getCode(),"服务器异常");
        }
    }
}
