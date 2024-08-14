package com.pwm.headline.common;

/**
 * ClassName: ResultCodeEnum
 * Package: com.demo.schedule.common
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/7/24 - 23:32
 * @Version: v1.0
 */
public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(50001, "usernameError"),
    PASSWORD_ERROR(50002, "passwordError"),
    NOTLOGIN(50003, "notlogin"),
    USERNAME_USED(50004, "usernameUsed"),
    USERNAME_NO_REGISTER(50005, "username no register");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
