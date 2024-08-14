package com.pwm.headline.service.impl;

import com.pwm.headline.dao.NewsUserDao;
import com.pwm.headline.dao.impl.NewsUserDaoImpl;
import com.pwm.headline.pojo.NewsUser;
import com.pwm.headline.service.NewsUserService;
import com.pwm.headline.util.MD5Util;

import java.util.List;

/**
 * ClassName: NewsUserServiceImpl
 * Package: com.pwm.headline.service.impl
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:20
 * @Version: v1.0
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao userDao = new NewsUserDaoImpl();
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public int register(NewsUser user) {
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        return userDao.register(user);
    }

    @Override
    public NewsUser login(NewsUser user) {
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        return userDao.login(user);
    }
}
