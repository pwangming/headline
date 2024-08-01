package com.pwm.headline.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlinePageVo
 * Package: com.pwm.headline.pojo.vo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:09
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlinePageVo implements Serializable {
    private Integer hid;
    private String title;
    private Integer type;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
}
