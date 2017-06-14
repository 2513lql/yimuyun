package com.project.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinda.model.ApplySlaughter;
import com.xinda.service.ApplySlaughterService;
import org.springframework.stereotype.Service;

/**
 * Created by LQL on 2017/6/10.
 */
@Service
public class LApplySlaughterService {


    @Reference
    private ApplySlaughterService applySlaughterService;

    public void insert(ApplySlaughter applySlaughter){
        applySlaughterService.insert(applySlaughter);
    }

}
