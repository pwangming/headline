package com.pwm.headline.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwm.headline.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
        // 设置JSON和object转换时的时间日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    // 从请求中获取JSON串并转换为object
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz) {
        T t = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            t = objectMapper.readValue(buffer.toString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
    // 将Result对象转换成JSON串并放入响应对象
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
