package com.monsterlin.bean;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc : 段子实体类
 */
public class Satin {
    private int sid ;
    private String author ;    //作者
    private String authorImg ; //作者头像
    private String content ; //段子内容
    private String source ; //来源
    private String fromUrl ; //原地址
    private String date ; //时间

    public Satin(String author, String authorImg, String content, String source, String fromUrl, String date) {
        this.author = author;
        this.authorImg = authorImg;
        this.content = content;
        this.source = source;
        this.fromUrl = fromUrl;
        this.date = date;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
