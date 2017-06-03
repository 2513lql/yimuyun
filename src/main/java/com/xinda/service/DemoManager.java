package com.xinda.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinda.model.AcidDischarge;
import com.xinda.model.AcidDischargeExample;
import com.xinda.model.Test;
import com.xinda.model.TestExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by antong on 17/4/24.
 */
@Component
public class DemoManager {
    @Reference
    private DemoService demoService;
    @Reference
    private AcidDischargeService acidDischargeService;


    public int test() {
        Test test = new Test();
        test.setTest("2222");
        return demoService.insert(test);
    }

    public Test queryTest(Long id){
        Test test = demoService.selectByPrimaryKey(id);
        return test;
    }

    public List<Test> queryDivider(int pageNum,int pageSize){
        TestExample testExample = new TestExample();
        testExample.createCriteria();
        testExample.setOrderByClause("id");
        testExample.setOffset((pageNum - 1) * pageSize);
        testExample.setLimit(20);
        List<Test> list = demoService.selectByExample(testExample);
        return list;
    }
//
//    public List<AcidDischarge> queryByDivider(int pageNum,int pageSize){
//
//        AcidDischargeExample acidDischargeExample = new AcidDischargeExample();
////        acidDischargeExample.setOrderByClause();
//
//    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo.xml");
        DemoManager demoManager = context.getBean("demoManager",DemoManager.class);
        Long id = 7l;
//        System.out.println(demoManager.queryTest(id).getTest());
        List<Test> examples = demoManager.queryDivider(1,5);
        for (Test test:examples){
            System.out.println(test.getTest());
        }
    }

}
