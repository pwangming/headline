package com.pwm.headline.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlineDetailVO
 * Package: com.pwm.headline.pojo.vo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:12
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineDetailVo implements Serializable {
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private String typeName;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
    private String author;
}
