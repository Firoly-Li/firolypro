package com.firolypro.services.impl;

import com.firolypro.configure.Executorconfig;
import com.firolypro.dataobj.Blog;
import com.firolypro.repository.BlogRepository;
import com.firolypro.services.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 2018/6/21
 * 上午11:17
 **/

@Service
public class BlogServiceImpl implements BlogService {

    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        logger.info(Thread.currentThread().getName());
        List<Blog> ls = blogRepository.findAll();
//        System.out.println("ls 张书说她不信= "+ls);
        return ls;
    }


    @Override
    public ListenableFuture<String> findByTitleLike(String title) {
        logger.info(Thread.currentThread().getName());
        List<String> ls = blogRepository.findByTitleLike("%"+title+"%");
       return new AsyncResult<>(ls.toString());
    }

//    @Override
//    public ListenableFuture<String> findByAuthorLike(String author) {
//        logger.info(Thread.currentThread().getName());
//        ListenableFuture<String> ls = blogRepository.findByAuthorLike("%"+author+"%");
//        return ls;
//
//    }

        @Override
    public ListenableFuture<String> findByAuthorLike(String author) {
        logger.info(Thread.currentThread().getName());
        List<String> ls = blogRepository.findByAuthorLike("%"+author+"%");
        return new AsyncResult<>(ls.toString());

    }

    @Override
    public ListenableFuture<String> findByTagsLike(String tags) {
        logger.info(Thread.currentThread().getName());
        List<String> ls = blogRepository.findByTagsLike("%"+tags+"%");
        return new AsyncResult<>(ls.toString());
    }



    @Override
    public Blog save(Blog blog) {
        logger.info(Thread.currentThread().getName());
        //获取当前时间，并且是Date类型
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date s = new Date();
        try {
            s= df.parse(df.format(s));

        } catch (ParseException e) {

            e.printStackTrace();
        }
        blog.setCreatetime(s);

        return blogRepository.save(blog);
    }
//
    @Override
    public Blog findOneById(int idblog) {
        logger.info(Thread.currentThread().getName());
        return blogRepository.findById(idblog).get();
    }

    /**
     *
     * 功能描述: 更新blog，只能更新title、tags、message这三个信息
     *
     * @param:
     * @return:
     * @auther:
     * @date:
     */
    @Override
    public Blog update(int id,String title,String tags,String message) {
        logger.info(Thread.currentThread().getName());
        Blog blog = blogRepository.findById(id).get();
        if(title!=""){
            blog.setTitle(title);
        }
        if(tags!=""){
            blog.setTags(tags);
        }
        if(message!=""){
            blog.setMessage(message);
        }
        blogRepository.save(blog);
        return blog;
    }
//
    @Override
    public void delectById(int id) {
        logger.info(Thread.currentThread().getName());
        blogRepository.deleteById(id);
    }
}
