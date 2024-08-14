package com.pwm.headline.dao;

import com.pwm.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewsUserDao
 * Package: com.pwm.headline.dao
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:15
 * @Version: v1.0
 */
public interface NewsUserDao {
    NewsUser findByUsername(String username);

    int register(NewsUser user);

    NewsUser login(NewsUser user);
}
