package com.wuyu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuyu.service.ApplicationContextHelp;
import com.wuyu.z.util.DefineParamService;

/**
 * Created by Administrator on 13-12-26.
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("")
    public void index(Model model, HttpServletResponse res) {
		try {
			res.getWriter().print("run...");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@RequestMapping("/ajax")
	@ResponseBody
	public Map<String, String> ajax(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		return map;
	}
	
	@RequestMapping("/param")
	public void param(HttpServletResponse res) {
		DefineParamService bean = ApplicationContextHelp.getBean("paramService", DefineParamService.class);
		try {
			res.getWriter().print(bean.getServerName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
