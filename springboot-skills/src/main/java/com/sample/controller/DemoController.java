package com.sample.controller;

import com.sample.service.DemoService;
import com.sample.service.impl.DemoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/5 10:13
 */
@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    /*
    背景：一个接口下面有多个实现类，通过注入接口依赖，调用指定的实现类下面的方法
        DemoService接口下面有2个实现类，DemoServiceImpl和DemoServiceImpl2
            - 这2个实现类下有相同的方法print(String)
            - 现在，在当前类即DemoController里面调用DemoServiceImpl2下面的print(String)
            - 在这种相对复杂的依赖注入情况下，使用不同的方法进行依赖注入
     */

    /*
    1.使用@Autowired注入依赖
        - @Qualifier指定实现类
     */
/*    @Autowired
    @Qualifier("demo2")
    DemoService demoService;*/

    /*
    2.使用@Resource注入依赖
     */
/*    @Resource
    @Qualifier("demo2")
    DemoService demoService;*/

    /*
    3.使用依赖对应的setter方法进行注入
     */
/*
    DemoService demoService;
    @Autowired
    private void setDemoService(@Qualifier("demo2") DemoService demoService){
        this.demoService = demoService;
    }
*/
    /*
    4.使用构造函数注入，更为可靠和安全
     */
/*    private final DemoService demoService;
    private DemoController(@Qualifier("demo2") DemoService demoService){
        this.demoService = demoService;
    }*/

    /*
    5.使用构造函数+lombok注解简化构造函数注入的步骤，使用lombok，@RequireArgConstructor提供final字段的参构造
        - 如果出现启动失败的情况，或鼠标悬浮在@Qualifier注解上提示不能复制到lombok到
            需要将项目跟目录下，新建一个名为lombok.config的配置文件，内容为一行代码，如下
            lombok.copyableAnnotations += org.springframework.beans.factory.annotation.Qualifier
            然后mvn clean，重新构建项目即可
     */
    @Qualifier("demo2")
    private final DemoService demoService;

    @GetMapping("/1")
    public String demo_1(@RequestParam String message){
        return demoService.print(message);
    }
}
