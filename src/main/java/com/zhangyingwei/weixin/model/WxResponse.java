package com.zhangyingwei.weixin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;

/**
 * Created by zhangyw on 2018/3/21.
 */

@ToString
public class WxResponse {
    @Setter
    private String toUserName;
    @Setter
    private String fromUserName;
    private String createTime;
    @Setter
    private String msgType;
    @Setter
    private String content;
    public WxResponse() {}

    public String toXml() {
        Document doc = new DOMDocument();
        Element root = new DOMElement("xml");
        doc.setRootElement(root);
        root.add(new DOMElement("ToUserName"){
            {
                setText(toUserName);
            }
        });
        root.add(new DOMElement("FromUserName"){
            {
                setText(fromUserName);
            }
        });
        root.add(new DOMElement("CreateTime"){
            {
                setText(getCreateTime());
            }
        });
        root.add(new DOMElement("MsgType"){
            {
                setText(msgType);
            }
        });
        root.add(new DOMElement("Content"){
            {
                setText(content);
            }
        });
        return doc.asXML();
    }

    public String getCreateTime() {
        return System.currentTimeMillis()/1000+"";
    }
}
