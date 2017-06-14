package com.project.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinda.model.News;
import com.xinda.model.NewsExample;
import com.xinda.service.NewsService;

import java.util.List;

/**
 * Created by LQL on 2017/6/10.
 */
public class LNewsService {

    @Reference
    private NewsService newsService;

    public List<News> getHomeNews(){
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        return newsService.selectByExample(newsExample);
    }

}
