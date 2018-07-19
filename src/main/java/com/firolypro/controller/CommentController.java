package com.firolypro.controller;

import com.firolypro.dataobj.Comments;
import com.firolypro.services.CommentService;
import com.firolypro.services.impl.CommentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.firolypro.controller
 * lihaoyang
 * 2018/6/28
 * 上午10:25
 **/

@CrossOrigin(origins = {"http://localhost:8080","null"})
@Controller
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Autowired
    private CommentService commentService;


    //添加一个评论（test），这只是个测试，这个应该是post方法

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public Comments save(){
        Comments comments = new Comments();
        comments.setCommentname("name");
        comments.setCommentedblogid("123");
        comments.setAuthor("commentAuthor");
        Comments resule = commentService.save(comments);
        return resule;
    }


    //查询某个用户的所有评论
    @ApiOperation(value = "根据author查询",notes = "模糊查询")
    @RequestMapping(value = "/findByAuthor/{author}",method = RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> find1(@PathVariable String author){
        logger.info("find1开始执行");
        logger.info(Thread.currentThread().getName());
        ListenableFuture<String> resule = commentService.findBycommentauthorLike(author);
        logger.info("find1即将执行结束");
        return resule;
    }


    //查询某一个帖子的所有评论（不同的人发不的关于特定帖子的所有评论）
    @ApiOperation(value = "根据CommentedId查询",notes = "模糊查询")
    @RequestMapping(value = "/findByCommentedId/{id}",method = RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> find2(@PathVariable String id){
        logger.info("find2开始执行");
        logger.info(Thread.currentThread().getName());
        ListenableFuture<String> resule = commentService.findBycommentedblogidLike(id);
        logger.info("find2即将执行结束");
        return resule;
    }

}
