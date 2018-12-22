package yz.weixin.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Okita.<br/>
 * User: yz<br/>
 * Date: 12/16/18<br/>
 * Time: 3:48 PM<br/>
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {
    public NewsMessage(Map<String, String> requestMap) {
        super(requestMap);
        setMsgType("news");
    }

    @XStreamAlias("MediaId")
    private String articleCount;
    private List<Article> articles = new ArrayList<>();

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
