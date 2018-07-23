package com.maz.forum.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.util.Date;
@Entity
public class Post {
    @Id
    private String id;
    private String author;
    private String title;
    private String content;
    private Date creationTime;
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public String getAuthor(String author) {
        return this.author;
    }

    public String getTitle(String title) {
        return this.title;
    }

    public String getContent(String content) {
        return this.content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setId(String id) {
        this.id = id;

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
