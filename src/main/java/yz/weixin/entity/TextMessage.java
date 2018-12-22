package yz.weixin.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 1:48 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextMessage(Map<String, String> requestMap, String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }

//    @Override
//    public String toString() {
//        return "TextMessage{" +
//                "content='" + content + '\'' +
//                "getToUserName()= " + getToUserName()
//                + "  getFromUserName()= " + getFromUserName()
//                + "  getCreateTime()= " + getCreateTime()
//                + "  getMsgType()= " + getMsgType() +
//        '}';
//    }
}
