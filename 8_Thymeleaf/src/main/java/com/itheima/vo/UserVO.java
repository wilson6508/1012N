package com.itheima.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {
    private String username;
    private Integer age;
    private Integer sex;
    private Boolean isVip;
    private Date createTime;
    private List<String> tags;
}
