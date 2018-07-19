package com.firolypro.repository;

import com.firolypro.dataobj.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * com.firolypro.repository
 * lihaoyang
 * 2018/6/21
 * 下午5:19
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository repository;

    @Test
    public void sd() {
        List<String> ls = repository.findByAuthorLike("ming");
        System.out.println(ls);
    }


}