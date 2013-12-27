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

    public List<Map<String, Object>> listSchools(int level) {
        return schoolDao.querySchoolCase(level);
    }
}
