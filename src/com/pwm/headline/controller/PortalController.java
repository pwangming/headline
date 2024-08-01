package com.pwm.headline.controller;

import com.pwm.headline.common.Result;
import com.pwm.headline.pojo.NewsType;
import com.pwm.headline.service.NewsTypeService;
import com.pwm.headline.service.impl.NewsTypeServiceImpl;
import com.pwm.headline.util.WEBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * ClassName: PortalController
 * Package: com.pwm.headline.controller
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:28
 * @Version: v1.0
 */

/**
 * 门户控制器
 * 不需要登录的页面，不需要做增删改的门户页的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private NewsTypeService typeService = new NewsTypeServiceImpl();

    /**
     * 查询所有头条类型的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllType(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<NewsType> newsTypeList = typeService.findAll();

        WEBUtil.writeJson(resp, Result.ok(newsTypeList));
    }
}
