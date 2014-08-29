package com.wuyu.controller;

import com.wuyu.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 13-12-26.
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    @Autowired
    SchoolService schoolService;
	private static final int feedSize = 8;

	@RequestMapping("")
    public String home(Model model) {
        //小学
        List<Map<String,Object>> level1 = schoolService.listSchools(1);

        //中学
        List<Map<String,Object>> level2 = schoolService.listSchools(2);

        //大学
        List<Map<String,Object>> level3 = schoolService.listSchools(3);

		List<Map<String, Object>> feedMaps = schoolService.listSchoolFeeds(feedSize);

		//全日制
        // TODO
        model.addAttribute("level1", level1);
        model.addAttribute("level2", level2);
        model.addAttribute("level3", level3);
		model.addAttribute("feeds", feedMaps);
        return "wy";
    }
	
	@RequestMapping("/test")
	public void test(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getWriter().print("run...");
	}
	
	
	@RequestMapping("/ajax")
	@ResponseBody
	public Map<String, String> ajax(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		return map;
	}
}
