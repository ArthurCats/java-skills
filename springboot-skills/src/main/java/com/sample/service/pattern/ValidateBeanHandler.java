package com.sample.service.pattern;

import com.sample.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/9/12 22:25
 */
@Component
public class ValidateBeanHandler {


    public Function<User, User> validatePassword(){
        return user -> {
            if (user.getName() == "timo"){
                throw new RuntimeException("用户名和密码不匹配");
            }
            return user;
        };
    }

    public Function<User, User> validateUserAge(){
        return user -> {
            if (user.getAge() < 18){
                throw new RuntimeException("未满18岁");
            }
            return user;
        };
    }
}
