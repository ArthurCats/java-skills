package com.sample.service.pattern;

import com.sample.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ValidateHandlerTest {

    /**
     * 责任链模式
     */
    @Test
    void validatePassword() {
        User timo = User.builder()
                .name("timo2")
                .age(16)
                .build();
        ValidateHandler.validatePassword()
                .andThen(ValidateHandler.validateUserAge())
                .apply(timo);
        System.out.println("this user is "+timo.toString());
    }

    @Resource
    private ValidateBeanHandler validateBeanHandler;

    @Test
    void validateTest(){
        User timo = User.builder()
                .name("timo2")
                .age(19)
                .build();
        validateBeanHandler.validatePassword()
                .andThen(validateBeanHandler.validateUserAge())
                .apply(timo);
        System.out.println("验证已通过，"+timo);
    }
}