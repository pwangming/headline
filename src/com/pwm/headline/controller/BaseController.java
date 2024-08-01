package com.pwm.headline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseController
 * Package: com.demo.schedule.controller
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/7/16 - 23:36
 * @Version: v1.0
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        System.out.println(methodName);
        // 通过反射获取要执行的方法
        Class clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 设置方法可以访问
            method.setAccessible(true);
            // 通过反射执行代码
            try {
                method.invoke(this, req, resp);
            } catch (InvocationTargetException | IllegalAccessException e) {
                Throwable cause = e.getCause();
                if (cause  instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                } else if (cause  instanceof Error) {
                    throw (Error) cause;
                } else {
                    throw new ServletException("Error invoking method", cause);
                }
            }
        } catch (NoSuchMethodException | SecurityException e) {
            // Handle method not found or security issues
            throw new ServletException("Method not found", e);
        }
    }
}
