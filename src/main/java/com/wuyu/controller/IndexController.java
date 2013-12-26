package com.wuyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 13-12-26.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String home() {
        return "wel";
    }
}
