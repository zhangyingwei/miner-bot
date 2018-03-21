package com.zhangyingwei.weixin.controller;

import com.zhangyingwei.weixin.handler.MinerHandler;
import com.zhangyingwei.weixin.model.WxRequest;
import com.zhangyingwei.weixin.model.WxResponse;
import com.zhangyingwei.weixin.utils.WxUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyw on 2018/3/21.
 */
@RestController
@RequestMapping
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private MinerHandler minerHandler;

    @GetMapping("/hello")
    public String hello(){
        return "hello weixin";
    }

    @GetMapping("/miner")
    public String token(String signature,String timestamp,String nonce,String echostr) {
        logger.info("收到验证请求");
        return echostr;
    }

    @PostMapping("/miner")
    public String action(HttpServletRequest request) throws IOException, DocumentException {
        WxRequest wxreq = WxUtils.getRequest(request);

        logger.info("{} 收到来自 {} 的消息",wxreq.getCreateTime(),wxreq.getFromUserName());
        if (WxUtils.isMySelf(wxreq.getFromUserName())) {
            return this.minerHandler.doHandler(wxreq).toXml();
        }else{
            WxResponse res = wxreq.toResponse();
            res.setContent("给你讲个笑话吧，你什么权限都没有");
            return res.toXml();
        }
    }
}