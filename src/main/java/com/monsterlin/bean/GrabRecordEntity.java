package com.monsterlin.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc : 抓取日志
 */
@Entity
@Table(name = "tb_grab_record", schema = "readme", catalog = "")
public class GrabRecordEntity {
    private int gid;
    private String content;
    private Timestamp date;

    @Id
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrabRecordEntity that = (GrabRecordEntity) o;

        if (gid != that.gid) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
