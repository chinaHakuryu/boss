package com.example.blog2.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhaomin_2017013792_CS181
 * @version 1.0
 * @date 2021/7/12 21:07
 */
@Entity
@Table(name = "t_project")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String pic_url;
    private String url;
    private String techs;

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

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTechs() {
        return techs;
    }

    public void setTechs(String techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", url='" + url + '\'' +
                ", techs='" + techs + '\'' +
                '}';
    }
}