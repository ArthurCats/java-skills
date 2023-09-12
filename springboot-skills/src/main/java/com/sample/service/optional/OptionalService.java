package com.sample.service.optional;

import com.sample.entity.Clothes;
import com.sample.entity.Student;
import com.sample.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/18 21:19
 */
@Service
public class OptionalService {

    /**
     * 正常写法，使用if判空
     */
    public void optionalUsage1(){
        String result = "";
        User user = new User();
        Clothes clothes = new Clothes();
        if(user != null){
            Clothes clothes1 = user.getClothes();
            if (clothes1 != null){
                String color = clothes1.getColor();
                result = color;
            }else {
                System.out.println("clothes 为空!");
            }
        }else {
            System.out.println("user 为空!");
        }
        System.out.println("颜色为：" + result);
    }

    /**
     * optional 错误用法1
     */
    public void optionalUsage2(User user){
        Optional<User> user1 = Optional.of(user);
        System.out.println("user1 = " + user1);
        User user2 = user1.get();
        Clothes clothes = user2.getClothes();
        String color = clothes.getColor(); // 空指针异常
        System.out.println("颜色是："+color);
    }

    public void optionalUsage3(User user){
        Optional<User> user1 = Optional.of(user);
        System.out.println("user1 = " + user1);
        User user2 = user1.get();
        Clothes clothes = user2.getClothes();
        String color = clothes.getColor(); // 空指针异常
        System.out.println("颜色是："+color);
    }

    /*
      如果用户名为空，返回 unknown user
        如果不为空，则返回用户名
     */
    public String getRealName(User user){
        if(user != null){
            return user.getName();
        }
        return "unknown user";
    }

    /*
  如果用户名为空，返回 unknown user
    如果不为空，则返回用户名
 */
    public String getRealName2(User user){
        return Optional.ofNullable(user)
                .map(user1 -> user1.getName())
                .orElse(null);
    }

    /**
     * 使用optional 处理集合
     */
    public List<Integer> dealCollection(List<Integer> list){
        return list.stream().map(e -> e + 1).collect(Collectors.toList());
    }

    /**
     * 使用optional 处理集合
     */
    public List<Integer> dealCollection2(List<Integer> list){
        return Optional.ofNullable(list)
                .map(list1 -> list1.stream()
                        .map(e->e+2)
                        .collect(Collectors.toList()))
                .orElseGet(()-> Arrays.asList(7,8,9));

    }

    /*
    需求：
    学校想从一批学生中，选出年龄大于等于18，参加过考试并且成绩大于80的人去参加比赛。
     */
    public List<Student> initData(){
        Student s1 = new Student("张三", 19, 80);
        Student s2 = new Student("李四", 19, 50);
        Student s3 = new Student("王五", 23, null);
        Student s4 = new Student("赵六", 16, 90);
        Student s5 = new Student("钱七", 18, 99);
        Student s6 = new Student("孙八", 20, 40);
        Student s7 = new Student("吴九", 21, 88);

        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
    }

    /*
    java8 之前的写法
     */
    public void qualifierStudent1(){
        List<Student> students = initData();
        for (Student student : students) {
            if (student != null){
                if(student.getAge() >= 18){
                    Integer score = student.getScore();
                    if(score != null && score > 80){
                        System.out.println("入选学生的姓名："+ student.getName());
                    }
                }
            }

        }
    }
    /*
    使用optional进行优化
     */
    public void qualifierStudent2(){
        List<Student> students = initData();
        // 遍历
        for (Student student : students) {
            Integer score = Optional.ofNullable(student)
                    .filter(student1 -> student1.getAge() >= 18)
                    .map(Student::getScore)
                    .orElse(0);
            if (score > 80){
                System.out.println("入选学生姓名:"+student.getName());
            }
        }
    }
}
