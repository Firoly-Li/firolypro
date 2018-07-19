package com.firolypro.controller;

import com.firolypro.backdataobj.BackBlog;
import com.firolypro.dataobj.Blog;
import com.firolypro.services.TestService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.ast.Test;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * com.firolypro.controller
 * lihaoyang
 * 2018/7/17
 * 下午3:25
 **/

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * 1
     * 功能描述: 获取所有的blog
     *
     * @param:
     * @return:
     * @auther:
     * @date:
     */

    @ApiOperation(value = "获取所有的blog列表",notes = "")
    @RequestMapping(value = "/getAllBlogs",method = RequestMethod.GET)
//    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> getAll(){
        System.out.println("运行controller方法的线程 = "+Thread.currentThread().getName());
       ListenableFuture<List<Blog>> ls = testService.findAll();
//        JSONArray lls = new JSONArray(ls);
        List<BackBlog> backbloglist = new ArrayList<>();
        List<Blog> lls = null;
        try {
            lls = ls.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for(int i = 0;i <lls.size();i++) {
            BackBlog backBlog = new BackBlog();
            backBlog.setIdBlog(lls.get(i).getIdBlog());
            backBlog.setAuthor(lls.get(i).getAuthor());
            backBlog.setMessage(lls.get(i).getMessage());
            backBlog.setTags(lls.get(i).getTags());
            backBlog.setTitle(lls.get(i).getTitle());
            backbloglist.add(backBlog);
        }
        return new AsyncResult<>(backbloglist.toString());
    }

}
