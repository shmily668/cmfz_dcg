package com.baizhi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Chapter implements Serializable {
    private String id;

    private String title;

    private String albumId;

    private String size;

    private String duration;

    private String src;

    private String status;

    private String other;

    public Chapter() {

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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", albumId='" + albumId + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", src='" + src + '\'' +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public Chapter(String id, String title, String albumId, String size, String duration, String src, String status, String other) {
        this.id = id;
        this.title = title;
        this.albumId = albumId;
        this.size = size;
        this.duration = duration;
        this.src = src;
        this.status = status;
        this.other = other;
    }
}