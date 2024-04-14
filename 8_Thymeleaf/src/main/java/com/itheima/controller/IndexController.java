package com.itheima.controller;

import com.itheima.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;

@Controller
public class IndexController {

    // Thymleaf
    // https://www.lookroot.cn/blog/code/216

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "中文標題");
        model.addAttribute("description", "傳遞的description");
        model.addAttribute("keywords", "傳遞的keywords");
        return "index";
    }

    @GetMapping("/basicTrain")
    public String basicTrain(Model model) {
        UserVO userVO = new UserVO();
        userVO.setUsername("Tom");
        userVO.setAge(22);
        userVO.setIsVip(true);
        userVO.setCreateTime(new Date());
        userVO.setSex(1);
        userVO.setTags(Arrays.asList("PHP", "Node", "Java"));
        model.addAttribute("user", userVO);
        return "basic";
    }

}
