package yz.weixin.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 2:54 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    // message id
    @XStreamAlias("MediaId")
    private String mediaId;

    public ImageMessage(Map<String, String> requestMap, String mediaId) {
        super(requestMap);
        this.setMsgType("image");
        this.mediaId =  mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
