package com.project.modules.web;

import com.project.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Xuan on 2017/7/11.
 */
@Controller
@RequestMapping(value="/logisticsReceiver")
public class LogisticsReceiverController extends BaseController {

    @RequestMapping(value = "signIn")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView("signIn");
        return modelAndView;
    }


}
