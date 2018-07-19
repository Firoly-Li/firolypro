package com.firolypro.services;

import com.firolypro.dataobj.Blog;
import com.firolypro.dataobj.Comments;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.services
 * lihaoyang
 * 2018/6/25
 * 上午11:36
 **/
public interface CommentService {

    //根据id查询
    Comments findById(int id);

    //添加一个user  增
    Comments save(Comments comments);

    //删除指定的评论表
    void delectById(int id);

    //模糊查询(根据Author)
    ListenableFuture<String> findBycommentauthorLike(String commentauthor);

    //
    ListenableFuture<String> findBycommentedblogidLike(String commentedblogid);

}
