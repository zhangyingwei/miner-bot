package com.zhangyingwei.weixin.utils;

import com.zhangyingwei.weixin.model.WxRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zhangyw on 2018/3/21.
 */
public class WxUtils {
    private static final String USERNAME = "oKEG1jlWO8fgdAjZLjEFVBVrjF4M";
    private static Element domFromRequest(HttpServletRequest request) throws IOException, DocumentException {
        ServletInputStream in = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        Element root = doc.getRootElement();
        return root;
    }

    public static WxRequest getRequest(HttpServletRequest request) throws IOException, DocumentException {
        return new WxRequest(domFromRequest(request));
    }

    public static Boolean isMySelf(String username){
        return USERNAME.equals(username);
    }

    public static boolean isCommand(String content) {
        return content.startsWith(":");
    }
}
