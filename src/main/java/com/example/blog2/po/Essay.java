package com.example.blog2.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhaomin_2017013792_CS181
 * @version 1.0
 * @date 2021/7/12 16:36
 */

@Entity
@Table(name = "t_essay")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Essay {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}