package com.zhangyingwei.weixin.handler;

import com.zhangyingwei.weixin.model.WxRequest;
import com.zhangyingwei.weixin.model.WxResponse;
import com.zhangyingwei.weixin.utils.CommandEnum;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyw on 2018/3/21.
 */
@Component
public class CommandHandler implements WxHandler {
    @Override
    public WxResponse doHandler(WxRequest request) {
        String command = request.getContent();
        WxResponse resp = request.toResponse();
        if (CommandEnum.HELP.getValue().equals(command)) {
            resp.setContent(":new 新建一条记录 \n :list 列出所有记录");
        }else if(CommandEnum.NEW.getValue().equals(command)){
            resp.setContent("请输入一条地址");
        }else {
            resp.setContent("未识别命令");
        }
        return resp;
    }
}
