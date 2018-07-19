package com.firolypro.services.impl;

import com.firolypro.dataobj.Blog;
import com.firolypro.repository.BlogRepository;
import com.firolypro.services.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * com.firolypro.services.impl
 * lihaoyang
 * 2018/6/21
 * 上午11:25
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    private BlogRepository repository;
    @Autowired
    private BlogService blogService;

    @Test   //测试findall成功13：55
    public void findAll() {
      List<Blog> ls = blogService.findAll();
      System.out.println("findAll查询出来的数据是："+ls);

    }

    @Test     //测试save成功15：55
    public void save() {
        Blog blog = new Blog();
        blog.setAuthor("atys");
        blog.setTags("v");
        blog.setTitle("testSave");
        blog.setMessage("This is a test for save");
        Blog result = blogService.save(blog);
    }

    @Test
    public void findOneById() {
    }

    @Test
    public void update() {
        Blog result = blogService.update(6,"ttest","c","test update");

    }

    @Test
    public void delectById() {
        Blog blog =  blogService.findOneById(6);
        System.out.println(blog);
    }


    @Test
    public void findByTitle(){
        ListenableFuture<String> ls =  blogService.findByTitleLike("tw");
        try {
            System.out.println(ls.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByAuthor(){
        ListenableFuture<String> ls = blogService.findByAuthorLike("ming");
        try {
            System.out.println(ls.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}