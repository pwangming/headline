package com.pwm.headline.service;

import com.pwm.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeService
 * Package: com.pwm.headline.service
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:21
 * @Version: v1.0
 */
public interface NewsTypeService {
    /**
     * 查询所有头条类型的方法
     * @return 多个头条类型以 List<NewsType> 集合形式返回
     */
    List<NewsType> findAll() throws Exception;
}
