package com.project.Test;

import com.project.modules.entity.TbHomePage;
import com.project.modules.service.TbHomePageService;
import com.project.service.HomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Spring 单元测试基类
 * @author ThinkGem
 * @version 2013-05-15
 */
@ContextConfiguration(locations = "classpath:applicationContext-dubbo.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTransactionalContextTests extends AbstractTransactionalJUnit4SpringContextTests {

	private final static Logger logger = LoggerFactory.getLogger(SpringTransactionalContextTests.class);

	@Autowired
	private TbHomePageService homePageService;

	@Test
	public void testGetHomeMessage(){
		TbHomePage homePage = homePageService.getHomePage();
		logger.info("SpringTransactionalContextTests.testGetHomeMessage homePage :{}",homePage);
	}

	
}
