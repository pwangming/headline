package com.pwm.headline.dao.impl;

import com.pwm.headline.dao.BaseDAO;
import com.pwm.headline.dao.NewsTypeDao;
import com.pwm.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDaoImpl
 * Package: com.pwm.headline.dao.impl
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:17
 * @Version: v1.0
 */
public class NewsTypeDaoImpl extends BaseDAO implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() throws Exception {
        String sql = "select tid, tname from news_type";
        return executeQuery(NewsType.class, sql);
    }
}
