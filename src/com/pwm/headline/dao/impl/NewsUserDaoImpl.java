package com.pwm.headline.dao.impl;

import com.pwm.headline.dao.BaseDAO;
import com.pwm.headline.dao.NewsUserDao;
import com.pwm.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewsUserDaoImpl
 * Package: com.pwm.headline.dao.impl
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:16
 * @Version: v1.0
 */
public class NewsUserDaoImpl extends BaseDAO implements NewsUserDao {
    @Override
    public NewsUser findByUsername(String username){
        try {
            String sql = "select uid, username as userName, user_pwd as userPwd, nick_name as nickName from news_user where username = ?";
            return executeQueryBean(NewsUser.class, sql, username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int register(NewsUser user) {
        try {
            String sql = "insert into news_user values(null, ?, ?, ?)";
            return executeUpdate(sql, user.getUserName(), user.getUserPwd(), user.getNickName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NewsUser login(NewsUser user) {
        try {
            String sql = "select uid, username as userName, nick_name as nickName from news_user where username = ? and user_pwd = ?";
            return executeQueryBean(NewsUser.class, sql, user.getUserName(), user.getUserPwd());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
