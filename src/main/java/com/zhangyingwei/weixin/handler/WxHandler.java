package com.zhangyingwei.weixin.handler;

import com.zhangyingwei.weixin.model.WxRequest;
import com.zhangyingwei.weixin.model.WxResponse;

/**
 * Created by zhangyw on 2018/3/21.
 */
public interface WxHandler {
    WxResponse doHandler(WxRequest request);
}
