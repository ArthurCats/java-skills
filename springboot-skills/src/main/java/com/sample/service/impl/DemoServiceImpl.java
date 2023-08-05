package com.sample.service.impl;

import com.sample.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 10:09
 */
@Service("demo1")
public class DemoServiceImpl implements DemoService {
    @Override
    public String print(String message) {
        return "i am from DemoServiceImpl : "+message;
    }
}
