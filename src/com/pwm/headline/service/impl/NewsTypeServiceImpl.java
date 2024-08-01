package com.pwm.headline.service.impl;

import com.pwm.headline.dao.NewsTypeDao;
import com.pwm.headline.dao.impl.NewsTypeDaoImpl;
import com.pwm.headline.pojo.NewsType;
import com.pwm.headline.service.NewsTypeService;

import java.util.List;

/**
 * ClassName: NewsTypeServiceImpl
 * Package: com.pwm.headline.service.impl
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:21
 * @Version: v1.0
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao typeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() throws Exception {
        return typeDao.findAll();
    }
}
