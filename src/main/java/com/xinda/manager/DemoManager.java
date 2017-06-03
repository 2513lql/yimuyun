package com.xinda.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinda.model.Test;
import com.xinda.service.DemoService;
import org.springframework.stereotype.Component;

/**
 * Created by antong on 17/4/24.
 */
@Component
public class DemoManager {
    @Reference
    private DemoService demoService;

    public int test() {
        Test test = new Test();
        test.setTest("2222");
        return demoService.insert(test);
    }
}
