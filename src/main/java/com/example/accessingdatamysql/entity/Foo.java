package com.example.accessingdatamysql.entity;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.Set;

@Data
public class Foo {
    @NotBlank(message="name 不能为空")
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;
}