package com.sample.service.pattern;

import com.sample.entity.User;

import java.util.function.Function;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/9/12 22:25
 */
public class ValidateHandler {


    public static Function<User, User> validatePassword(){
        return user -> {
            if (user.getName() == "timo"){
                throw new RuntimeException("yonghu yic");
            }
            return user;
        };
    }

    public static Function<User, User> validateUserAge(){
        return user -> {
            if (user.getAge() < 18){
                throw new RuntimeException("未满18岁");
            }
            return user;
        };
    }
}
