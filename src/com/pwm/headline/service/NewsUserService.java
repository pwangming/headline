package com.pwm.headline.service;

import com.pwm.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewUserService
 * Package: com.pwm.headline.service
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:19
 * @Version: v1.0
 */
public interface NewsUserService {
    NewsUser findByUsername(String username);

    int register(NewsUser user);

    NewsUser login(NewsUser user);
}
