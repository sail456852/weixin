package yz.weixin;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;
import yz.weixin.entity.*;
import yz.weixin.util.TokenUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 1:53 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public class WxTest {
    
    @Test
    public void buttonTest() {
        Button btn = new Button();
        btn.getButton().add(new ClickButton("L1C", "1C"));
        btn.getButton().add(new ViewButton("L1V", "www.baidu.com"));
        SubButton sb = new SubButton();
        sb.setName("SUBME");
        sb.getSub_button().add(new ClickButton("L2Click", "2C"));
        sb.getSub_button().add(new ViewButton("L2view", "www.hao123.com"));
        sb.getSub_button().add(new PhoteOrAlbumButton("Level2P", "2P"));
        btn.getButton().add(sb);
        String btnCreateJsonString = JSON.toJSONString(btn);
        System.err.println("jsonString = " + btnCreateJsonString);
        String createMenuUrlTmpl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&scope=snsapi_base";
        String accessToken = TokenUtil.getAccessToken().getAccessToken();
        System.err.println("accessToken = " + accessToken);
        createMenuUrlTmpl = createMenuUrlTmpl.replace("ACCESS_TOKEN", accessToken);
        System.err.println("createMenuUrlTmpl = " + createMenuUrlTmpl);
        String btnCreateResp = TokenUtil.requestUrlPost(createMenuUrlTmpl, btnCreateJsonString);
        System.err.println("btnCreateResp = " + btnCreateResp);
    }


    @Test
    public void xmlStrToMap() {
        String xmlStr = "<xml>  <ToUserName>< ![CDATA[toUser] ]></ToUserName>  <FromUserName>< ![CDATA[fromUser] ]></FromUserName>  <CreateTime>1348831860</CreateTime>  <MsgType>< ![CDATA[text] ]></MsgType>  <Content>< ![CDATA[this is a test] ]></Content>  <MsgId>1234567890123456</MsgId>  </xml>";
    }

    @Test
    public void testMsg() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("ToUserName", "YZHOME");
        requestMap.put("FromUserName", "YUZHEN");
        requestMap.put("MsgType", "type");
        TextMessage tm = new TextMessage(requestMap, "Just Okay");
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(NewsMessage.class);
        String xml = stream.toXML(tm);
        System.err.println(xml);
    }
}
