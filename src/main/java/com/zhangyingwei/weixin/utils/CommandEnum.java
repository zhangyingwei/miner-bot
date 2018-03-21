package com.zhangyingwei.weixin.utils;

import lombok.Getter;

/**
 * Created by zhangyw on 2018/3/21.
 */
public enum  CommandEnum {
    HELP(":help"),
    NEW(":new");

    @Getter
    private String value;
    CommandEnum(String value) {
        this.value = value;
    }
}
