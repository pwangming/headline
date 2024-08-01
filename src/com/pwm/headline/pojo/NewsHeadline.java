package com.pwm.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: NewsHeadline
 * Package: com.pwm.headline.pojo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:05
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsHeadline implements Serializable {
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private Integer publisher;
    private Integer pageViews;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
