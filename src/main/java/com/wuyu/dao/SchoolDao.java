package com.wuyu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 13-12-27.
 */
@Repository
public class SchoolDao {

    @Autowired
    private JdbcTemplate template;

    public List<Map<String,Object>> querySchoolCase(int level) {

        return template.queryForList(QUERY_BY_LEVEL, level);
    }

	public List<Map<String, Object>> querySchoolFeed(int size) {
		return template.queryForList(QUERY_FEED, size);
	}


    private static final String QUERY_BY_LEVEL =
            "SELECT * FROM SCHOOL_CASE WHERE SCHOOL_LEVEL = ?";

	private static final String QUERY_FEED = "SELECT * FROM SCHOOL_FEED order by c_time " +
			" desc limit ?";
}
