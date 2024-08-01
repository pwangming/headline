package com.pwm.headline.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlineQueryVo
 * Package: com.pwm.headline.pojo.vo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:08
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineQueryVo implements Serializable {
    private String keyWords;
    private Integer type;
    private Integer pageNum;
    private Integer pageSize;
}
