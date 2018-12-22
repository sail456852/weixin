package yz.weixin.entity;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 3:46 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Article {
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public Article(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
