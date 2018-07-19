package com.firolypro.services.impl;

import com.firolypro.dataobj.Comments;
import com.firolypro.repository.CommentRepository;
import com.firolypro.services.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * com.firolypro.services.impl
 * lihaoyang
 * 2018/6/25
 * 下午1:50
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

//    @Test
//    public void findByCommentName() {
//        commentService.findByCommentName("testcomment");
//    }

    @Test
    public void findById() {
        commentService.findById(1);
    }


    @Test
    public void save() {
        Comments comments = new Comments();
        comments.setCommentname("testcomment");
        comments.setCommentedblogid("1");
        commentService.save(comments);

    }

    @Test
    public void delectById() {
        commentService.delectById(2);
    }


    @Test
    public void findByCommentedBlogId() {
        ListenableFuture<String> ls = commentService.findBycommentedblogidLike("23");
    }


    @Test
    public void findByCommentAuthor() {
        List<Comments> ls = commentRepository.findBycommentauthorLike("as");
    }
//
//
//    @Test
//    public void findByAuthorLike() {
//        List<Comments> ls = commentService.findByAuthorLike("as");
//    }
}