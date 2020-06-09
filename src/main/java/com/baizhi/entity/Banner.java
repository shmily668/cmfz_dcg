package com.baizhi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Banner implements Serializable {
    private String id;
    private String title;
    private String img;
    private Date createDate;
    private String status;
    private String other;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Banner(String id, String title, String img, Date createDate, String status, String other) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.createDate = createDate;
        this.status = status;
        this.other = other;
    }

    public Banner() {
    }
}