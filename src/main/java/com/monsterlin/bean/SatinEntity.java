package com.monsterlin.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc : 段子实体类
 */
@Entity
@Table(name = "tb_satin", schema = "readme", catalog = "")
public class SatinEntity {
    private int sid;
    private String author;
    private String authorImg;
    private String content;
    private String source;
    private String fromUrl;
    private String date;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "authorImg")
    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "fromUrl")
    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SatinEntity that = (SatinEntity) o;

        if (sid != that.sid) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (authorImg != null ? !authorImg.equals(that.authorImg) : that.authorImg != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (fromUrl != null ? !fromUrl.equals(that.fromUrl) : that.fromUrl != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (authorImg != null ? authorImg.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (fromUrl != null ? fromUrl.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
