package com.pwm.headline.util;

import com.demo.schedule.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ClassName: WEBUtil
 * Package: com.demo.schedule.util
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/7/27 - 0:07
 * @Version: v1.0
 */
public class WEBUtil {
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
    }
    public static void writeJson(HttpServletResponse resp, Result result) {
        resp.setContentType("application/json;charset=UTF-8");
        try {
            String info = objectMapper.writeValueAsString(result);
            resp.getWriter().write(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
