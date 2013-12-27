package com.wuyu.service.test;

import com.wuyu.service.SchoolService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 13-12-27.
 */
public class SchoolServiceTest {

    ApplicationContext ctx = null;
    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(new String[]{
                "applicationContext.xml", "wuyumvc-servlet.xml"});
    }

    @Test
    public void testList() {
        SchoolService schoolService = ctx.getBean("schoolService", SchoolService.class);
        List<Map<String,Object>> maps = schoolService.listSchools(1);
        System.out.println(maps);
        Assert.assertEquals(true, true);
    }

}
