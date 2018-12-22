package yz.weixin.entity;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 3:43 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Music {
    private String title;
    private String description;
    private String musicUrl;
    private String hQmusicUrl;
    private String thumbMediaId;

    public Music(String title, String description, String musicUrl, String hQmusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hQmusicUrl = hQmusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String gethQmusicUrl() {
        return hQmusicUrl;
    }

    public void sethQmusicUrl(String hQmusicUrl) {
        this.hQmusicUrl = hQmusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
