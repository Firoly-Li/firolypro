package com.firolypro.repository;


import com.firolypro.dataobj.Blog;
import com.firolypro.dataobj.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.repository
 * lihaoyang
 * 2018/6/25
 * 上午11:35
 **/
public interface CommentRepository extends JpaRepository<Comments,Integer> {
    List<Comments> findBycommentedblogidLike(String commentedblogid);

    List<Comments> findBycommentauthorLike(String commentauthor);
}
