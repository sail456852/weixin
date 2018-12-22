package yz.weixin.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 3:34 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {
    public VoiceMessage(Map<String, String> requestMap) {
        super(requestMap);
    }

    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public VoiceMessage(Map<String, String> requestMap, String mediaId) {
        super(requestMap);
        this.mediaId = mediaId;
    }
}
