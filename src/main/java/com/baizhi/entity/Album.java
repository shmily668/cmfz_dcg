package com.baizhi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Album implements Serializable {
    private String id;

    private String title;

    private String img;

    private String score;

    private String author;

    private String broadcaster;

    private String count;

    private String brief;

    private Date createDate;

    private String status;

    private String other;

    public Album() {

    }

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadcaster='" + broadcaster + '\'' +
                ", count='" + count + '\'' +
                ", brief='" + brief + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Album(String id, String title, String img, String score, String author, String broadcaster, String count, String brief, Date createDate, String status, String other) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.score = score;
        this.author = author;
        this.broadcaster = broadcaster;
        this.count = count;
        this.brief = brief;
        this.createDate = createDate;
        this.status = status;
        this.other = other;
    }
}