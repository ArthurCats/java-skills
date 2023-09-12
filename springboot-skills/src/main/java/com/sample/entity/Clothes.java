package com.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Zheng
 * @CreateTime 2023/8/18 21:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    private String color;

    private String size;
}
