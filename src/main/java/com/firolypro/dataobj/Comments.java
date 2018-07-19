package com.firolypro.dataobj;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * com.firolypro.dataobj
 * lihaoyang
 * 2018/6/25
 * 上午11:02
 **/
@Entity
@DynamicUpdate  //自动更新数据
@DynamicInsert  //动态插入
@Data
public class Comments {
    /**
     *
     * 功能描述: 这个是评论表的总表，存储的是各个评论表的信息，
     * 系统根据这个表去实时修改具体评论表中的信息
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idcomments;



    //评论者的名称
    private String commentauthor;
    //评论的内容
    private String commentname;

    //被评论的blog的id
    private String commentedblogid;
    //评论时间
    private Date commentdate;



    public int getIdcomment() {
        return idcomments;
    }

    public void setIdcomment(int idcomment) {
        this.idcomments = idcomment;
    }

    public String getCommentname() {
        return commentname;
    }

    public void setCommentname(String commentname) {
        this.commentname = commentname;
    }

    public String getCommentedblogid() {
        return commentedblogid;
    }

    public void setCommentedblogid(String commentedblogid) {
        this.commentedblogid = commentedblogid;
    }

    public String getAuthor() {
        return commentauthor;
    }

    public void setAuthor(String commentauthor) {
        this.commentauthor = commentauthor;
    }

    public Date getDate() {
        return commentdate;
    }

    public void setDate(Date commentdate) {
        this.commentdate = commentdate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"commentname\":\"" + commentname + '\"' +
                ", \"commentedblogid\":" + "\""+commentedblogid+"\"" +
                "}";
    }
}
