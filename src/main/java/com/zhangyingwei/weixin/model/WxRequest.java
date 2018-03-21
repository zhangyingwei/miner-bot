package com.zhangyingwei.weixin.model;

import lombok.Getter;
import lombok.Setter;
import org.dom4j.Element;

/**
 * Created by zhangyw on 2018/3/21.
 */
@Setter
@Getter
public class WxRequest {
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;
    private String msgId;
    private String content;

    public WxRequest() {}
    public WxRequest(Element root) {
        this.loadFromXml(root);
    }

    private void loadFromXml(Element root) {
        this.setFromUserName(root.elementText("FromUserName"));
        this.setToUserName(root.elementText("ToUserName"));
        this.setCreateTime(root.elementText("CreateTime"));
        this.setMsgId(root.elementText("MsgId"));
        this.setMsgType(root.elementText("MsgType"));
        this.setContent(root.elementText("Content"));
    }

    public WxResponse toResponse() {
        WxResponse res = new WxResponse();
        res.setFromUserName(this.getToUserName());
        res.setToUserName(this.getFromUserName());
        res.setMsgType(this.getMsgType());
        return res;
    }
}
