package com.service.posts;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "POSTS")
class Posts{

    private @Id @GeneratedValue @Column(name = "POST_ID") Long pid;
    private String title;
    private String text;

    private Long uid;
    Posts() {}

    Posts(String title, String text, Long uid) {
        this.pid = pid;
        this.title = title;
        this.text = text;
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setId(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUser() {
        return uid;
    }

    public void setUser(Long uid) {
        this.uid = uid;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Posts{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user=" + uid +
                '}';
    }
}