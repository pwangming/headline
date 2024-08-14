package com.pwm.headline.controller;

import com.pwm.headline.common.Result;
import com.pwm.headline.common.ResultCodeEnum;
import com.pwm.headline.pojo.NewsUser;
import com.pwm.headline.service.NewsUserService;
import com.pwm.headline.service.impl.NewsUserServiceImpl;
import com.pwm.headline.util.JwtHelper;
import com.pwm.headline.util.MD5Util;
import com.pwm.headline.util.WEBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.pwm.headline.util.WEBUtil.writeJson;

/**
 * ClassName: NewsUserController
 * Package: com.pwm.headline.controller
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:26
 * @Version: v1.0
 */
@WebServlet("/user/*")
public class NewsUserController extends BaseController{
    private NewsUserService userService = new NewsUserServiceImpl();
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("user_pwd");
//        String nickName = req.getParameter("nick_name");
//        NewsUser user = new NewsUser(null, username, userPwd, nickName);
//        NewsUser newsUser = userService.findUsername(NewsUser user);
//        Result result = null;
//        if (null == newsUser) {
//            int row = userService.register(user);
//            result = result.ok(null);
//        } else {
//            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
//        }
//        writeJson(resp, result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser paramUser = WEBUtil.readJson(req, NewsUser.class);
        NewsUser loginUser = userService.findByUsername(paramUser.getUserName());
        Result result = null;
        if (null == loginUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        } else {
            if (MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())) {
                Map data = new HashMap();
                data.put("token", JwtHelper.createToken(loginUser.getUid().longValue()));
                result = Result.ok(data);
            } else {
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        writeJson(resp, result);
    }
}
