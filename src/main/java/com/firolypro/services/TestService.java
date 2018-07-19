package com.firolypro.services;

import com.firolypro.dataobj.Blog;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.services.impl
 * lihaoyang
 * 2018/7/17
 * 下午3:24
 **/
public interface TestService {
    //查找所有的数据
    ListenableFuture<List<Blog>> findAll();
}
