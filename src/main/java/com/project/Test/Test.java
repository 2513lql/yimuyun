package com.project.Test;

import com.project.modules.entity.TbHomePage;
import com.project.modules.entity.TbLeaveMessage;
import com.project.modules.entity.TbNews;
import com.project.modules.service.TbHomePageService;
import com.project.modules.service.TbHonorService;
import com.project.modules.service.TbLeaveMessageService;
import com.project.modules.service.TbNewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by LQL on 2017/6/10.
 */
public class Test {


    public static void testHomePageService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo.xml");
        TbHomePageService tbHomePageService = context.getBean("tbHomePageService",TbHomePageService.class);
        TbHomePage homePage =  tbHomePageService.getHomePage();
        System.out.println(homePage.getTelephoneNumber());
    }

    public static void testNewsService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo.xml");
        TbNewsService tbNewsService = context.getBean("tbNewsService",TbNewsService.class);
        List<TbNews> newses =  tbNewsService.getTopThree("1");
        for (TbNews news:newses){
            System.out.println(news.getBody());
        }
    }

    public static void testLeaveMessage(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo.xml");
        TbLeaveMessageService leaveMessageService = context.getBean("tbLeaveMessageService",TbLeaveMessageService.class);
        TbLeaveMessage tbLeaveMessage = new TbLeaveMessage();
        tbLeaveMessage.setContact("123");
        tbLeaveMessage.setDescribe("小明");
        tbLeaveMessage.setProblemType("哈哈");
        leaveMessageService.save(tbLeaveMessage);

    }
//
//    public static void testApplySlaughter(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo.xml");
//        HomeService homeService = context.getBean("homeService",HomeService.class);
//        homeService.insert();
//    }


    public static void main(String[] args) {
//            testLeaveMessage();
//        testHomePageService();
//        testNewsService();

        System.out.println("你好");
    }


}
