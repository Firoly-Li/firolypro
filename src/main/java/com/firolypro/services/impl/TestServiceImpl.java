package com.firolypro.services.impl;

import com.firolypro.dataobj.Blog;
import com.firolypro.repository.BlogRepository;
import com.firolypro.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.services.impl
 * lihaoyang
 * 2018/7/17
 * 下午3:25
 **/

@Service
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogRepository blogRepository;

    @Override
    @Async("asyncServiceExecutor")
    public ListenableFuture<List<Blog>> findAll() {
        logger.info(Thread.currentThread().getName());
        List<Blog> ls = blogRepository.findAll();
//        System.out.println("ls 张书说她不信= "+ls);
        System.out.println("运行findAll方法的线程名 = "+Thread.currentThread().getName());
        return new AsyncResult<>(ls);
    }
}
