package com.firolypro.backdataobj;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * com.firolypro.backdataobj
 * lihaoyang
 * 2018/7/17
 * 上午11:33
 **/
@Entity
@DynamicUpdate  //自动更新数据
public class BackBlog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idblog;

    //标题
    private String title;

    //标签
    private String tags;

    //作者
    private String author;

    //内容
    private String message;


    public BackBlog(){}

    public BackBlog(String title,String tags,String author,String message){
        this.title = title;
        this.tags = tags;
        this.author = author;
        this.message = message;
    }


    public int getIdBlog() {
        return idblog;
    }

    public void setIdBlog(int idblog) {
        this.idblog = idblog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String toString(){
        return "{\"idblog\":"+idblog+",\"tags\":\""+tags+"\",\"title\":\""+title+"\",\"author\":\""+author+"\",\"messge\":\""+message+"\"}";
    }

}
