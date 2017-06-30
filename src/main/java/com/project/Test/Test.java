package com.project.Test;

import com.project.common.utils.ConfigUtil;
import com.project.modules.entity.TbHomePage;
import com.project.modules.entity.TbLeaveMessage;
import com.project.modules.entity.TbNews;
import com.project.modules.service.TbHomePageService;
import com.project.modules.service.TbHonorService;
import com.project.modules.service.TbLeaveMessageService;
import com.project.modules.service.TbNewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
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
//        List<TbNews> newses =  tbNewsService.getTopThree("2");
        for (int i = 0 ; i < 20;i++){
            TbNews tbnews = new TbNews();
            tbnews.setCreateTime(new Date());
            tbnews.setUpdateTime(new Date());
            tbnews.setAuthor("小明");
            tbnews.setDigest("近日，哈尔滨万达滑雪乐园正在紧张施工中，");
            tbnews.setShowLocation(ConfigUtil.getIndustryNewsLocation());
            tbnews.setIstop("0");
            tbnews.setTitle("哈尔滨万达滑雪乐园造型初现");
            tbnews.setPicture("upload/20170620183311.jpg");
            tbnews.setBody("<p><br/></p><p><br/></p><p>&nbsp; &nbsp;\t\t\t\t\t\t\t\t\t\t央视网消息：“农村贫困人口如期脱贫、贫困县全部摘帽、解决区域性整体贫困，是全面建成小康社会的底线任务，是我们作出的庄严承诺。”2017年2月21日，习近平总书记在主持中共中央政治局第三十九次集体学习时强调，要集中力量攻坚克难，更好推进精准扶贫、精准脱贫，确保如期实现脱贫攻坚目标。&nbsp;<br/><br/>　　消除贫困、改善民生、逐步实现共同富裕，是社会主义的本质要求，是中国共产党的重要使命。改革开放以来，中国实施大规模扶贫开发，使7亿农村贫困人口摆脱贫困，取得了举世瞩目的伟大成就，谱写了人类历史上反贫困的辉煌篇章。党的十八大以来，中国把扶贫开发工作纳入“四个全面”战略布局，作为实现第一个百年奋斗目标的重点工作，摆在更加突出的位置，大力实施精准扶贫，不断丰富和拓展中国特色扶贫开发道路，不断开创扶贫开发事业新局面。<br/><br/>　　中国扶贫开发已进入啃硬骨头、攻坚拔寨的冲刺期。中西部一些省（自治区、直辖市）贫困人口规模依然较大，剩下的贫困人口贫困程度较深，减贫成本更高，脱贫难度更大。实现到2020年让7000多万农村贫困人口摆脱贫困的既定目标，时间十分紧迫、任务相当繁重。<br/><br/>　　《“十三五”脱贫攻坚规划》（以下简称“规划”）明确了打赢脱贫攻坚战的时间表和路线图，《规划》按照精准扶贫精准脱贫基本要求，因地制宜，分类施策，从八个方面实化细化了相关路径和措施。“规划”是我国脱贫攻坚战的“兵法总则”，各地正按照这个规划，将扶贫脱贫攻坚进一步深化、细化、具体化，铸造适合自己的“剑与矛”，在2017脱贫攻坚决战之关键年，攻城拔寨，决战决胜。</p><p><br/></p><p><img src=\"/yimuyun_web/ueditor/jsp/upload/image/20170615/1497528112361012832.jpg\" alt=\"1497528112361012832.jpg\"/></p><p><br/></p><p><br/></p>");
            tbNewsService.save(tbnews);
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
        testNewsService();

//        System.out.println("你好");
    }


}
