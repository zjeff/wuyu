package com.wuyu.dao.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * Created by Administrator on 13-12-27.
 */
public class SchoolDaoTest {
    ApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(new String[]{
                "applicationContext.xml", "wuyumvc-servlet.xml"});
    }

    @Test
    public void testAdd() {
        JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "INSERT INTO school_case(school_name, school_logo, school_intro, " +
                " school_level, is_full_time, c_time) VALUES(?, ?, ?, ?, ?, ?)";
        Date date = new Date();
        for(int i=1; i<10; i++) {
            jdbcTemplate.update(sql, new Object[]{"小学", "p"+ i +".jpg", "", 1, 1, date});
        }
    }


	@Test
	public void testAddSchoolFeed() {
		JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "INSERT INTO school_feed(title, content, c_time, u_time, u_id" +
				" ) VALUES(?, ?, ?, ?, ?)";
		Date date = new Date();
		for(int i=1; i<10; i++) {
			jdbcTemplate.update(sql, new Object[]{"校园动态标题", "校园动态内容", date, date, 1});
		}
	}
}
