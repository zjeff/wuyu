package com.wuyu.service;

import com.wuyu.dao.SchoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 13-12-27.
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;

	/**
	 * 查询学校
	 * @param level 1:小学；2:初中；3:大学
	 * @return
	 */
    public List<Map<String, Object>> listSchools(int level) {
        return schoolDao.querySchoolCase(level);
    }


	/**
	 * 查询动态
	 * @param size
	 * @return
	 */
	public List<Map<String, Object>> listSchoolFeeds(int size) {
		return schoolDao.querySchoolFeed(size);
	}
}
