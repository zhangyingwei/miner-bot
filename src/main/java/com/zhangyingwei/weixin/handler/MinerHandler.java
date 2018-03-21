package com.zhangyingwei.weixin.handler;

import com.zhangyingwei.weixin.model.WxRequest;
import com.zhangyingwei.weixin.model.WxResponse;
import com.zhangyingwei.weixin.utils.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyw on 2018/3/21.
 */

@Component
public class MinerHandler implements WxHandler{

    @Autowired
    private CommandHandler commandHandler;

    @Override
    public WxResponse doHandler(WxRequest request) {
        String content = request.getContent();
        if (WxUtils.isCommand(content)) {
            return this.commandHandler.doHandler(request);
        }
        WxResponse resp = request.toResponse();
        resp.setContent("逗你玩");
        return resp;
    }
}
