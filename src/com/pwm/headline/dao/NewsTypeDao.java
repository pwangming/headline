package com.pwm.headline.dao;

import com.pwm.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDao
 * Package: com.pwm.headline.dao
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:17
 * @Version: v1.0
 */
public interface NewsTypeDao {
    List<NewsType> findAll() throws Exception;
}
