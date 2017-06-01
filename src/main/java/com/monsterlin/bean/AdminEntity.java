package com.monsterlin.bean;

import javax.persistence.*;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/24
 * desc : 管理员实体类
 */
@Entity
@Table(name = "tb_admin", schema = "readme", catalog = "")
public class AdminEntity {
    private int aid;
    private String username;
    private String userpass;

    @Id
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpass")
    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (aid != that.aid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userpass != null ? !userpass.equals(that.userpass) : that.userpass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpass != null ? userpass.hashCode() : 0);
        return result;
    }
}
