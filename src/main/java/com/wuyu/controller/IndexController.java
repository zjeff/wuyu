package com.wuyu.controller;

import com.wuyu.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 13-12-26.
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping("")
    public String home(Model model) {
        //小学
        List<Map<String,Object>> level1 = schoolService.listSchools(1);

        //中学
        List<Map<String,Object>> level2 = schoolService.listSchools(2);

        //大学
        List<Map<String,Object>> level3 = schoolService.listSchools(3);

        //全日制
        // TODO
        System.out.println(level1.size());
        model.addAttribute("level1", level1);
        model.addAttribute("level2", level2);
        model.addAttribute("level3", level3);
        return "wy";
    }
}
