package com.firolypro.services.impl;

import com.firolypro.dataobj.Blog;
import com.firolypro.dataobj.Comments;
import com.firolypro.repository.CommentRepository;
import com.firolypro.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * com.firolypro.services.impl
 * lihaoyang
 * 2018/6/25
 * 上午11:40
 **/

@Service
public class CommentServiceImpl implements CommentService{
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comments findById(int id) {
        logger.info(Thread.currentThread().getName());
        Comments result = commentRepository.findById(id).get();
        return result;
    }


    @Override
    public Comments save(Comments comments) {
        logger.info(Thread.currentThread().getName());
        //获取当前时间，并且是Date类型
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date s = new Date();
        try {
            s= df.parse(df.format(s));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        comments.setDate(s);

        return commentRepository.save(comments);
    }

    @Override
    public void delectById(int id) {
        logger.info(Thread.currentThread().getName());
        commentRepository.deleteById(id);
        System.out.println("success");
    }

    @Override
//    @Async("asyncServiceExecutor")
    public ListenableFuture<String> findBycommentauthorLike(String commentauthor) {
        logger.info("findBycommentauthorLike开始执行");
        logger.info(Thread.currentThread().getName());
        List<Comments> ls = commentRepository.findBycommentauthorLike("%"+commentauthor+"%");
        logger.info("findBycommentauthorLike即将执行结束");
        return new AsyncResult<>(ls.toString());

    }

    @Override
//    @Async("asyncServiceExecutor")
    public ListenableFuture<String> findBycommentedblogidLike(String commentedblogid) {
        List<Comments> ls = null;
        try {
            logger.info("findBycommentedblogidLike开始执行");
            logger.info(Thread.currentThread().getName());
             ls = commentRepository.findBycommentedblogidLike("%"+commentedblogid+"%");
            logger.info("findBycommentedblogidLike即将执行结束");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(ls.toString());
    }

}
