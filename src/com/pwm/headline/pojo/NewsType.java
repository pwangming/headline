package com.pwm.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsType
 * Package: com.pwm.headline.pojo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:03
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsType implements Serializable {
    private Integer tid;
    private String tname;
}
