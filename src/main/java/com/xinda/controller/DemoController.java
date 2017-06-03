package com.xinda.controller;

import com.xinda.service.DemoManager;
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
    public int test1() {
        return demoManager.test();
    }
}
