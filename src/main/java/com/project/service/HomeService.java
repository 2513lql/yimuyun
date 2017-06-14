package com.project.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinda.model.ApplySlaughter;
import com.xinda.service.ApplySlaughterService;
import org.springframework.stereotype.Component;

/**
 * Created by LQL on 2017/6/10.
 */
@Component("homeService1")
public class HomeService {

//    @Reference
//    private HomePageService homePageService;
//
    @Reference
    private ApplySlaughterService applySlaughterService;
//
//    public List<HomePage> getHomePages(){
//        HomePageExample homePageExample = new HomePageExample();
//        List<HomePage> homePages = homePageService.selectByExample(homePageExample);
//        return homePages;
//    }
//
    public void insert(ApplySlaughter applySlaughter){
        applySlaughterService.insert(applySlaughter);
    }

}
