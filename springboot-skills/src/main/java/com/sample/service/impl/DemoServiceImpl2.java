package com.sample.service.impl;

import com.sample.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 11:05
 */
@Service("demo2")
public class DemoServiceImpl2 implements DemoService {
    @Override
    public String print(String message) {
        return "demo2:"+message;
    }
}
