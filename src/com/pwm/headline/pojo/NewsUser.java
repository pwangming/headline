package com.pwm.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsUser
 * Package: com.pwm.headline.pojo
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/8/1 - 23:01
 * @Version: v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsUser implements Serializable {
    private Integer uid;
    private String userName;
    private String userPwd;
    private String nickName;
}
