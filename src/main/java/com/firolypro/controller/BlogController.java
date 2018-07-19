package com.firolypro.controller;

import com.firolypro.backdataobj.BackBlog;
import com.firolypro.dataobj.Blog;
import com.firolypro.services.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * com.firolypro.controller
 * lihaoyang
 * 2018/6/21
 * 下午6:03
 **/
@Api("接口")
@CrossOrigin(origins = {"http://localhost:8080","null"})
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

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
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> getAll(){
        List<Blog> ls = blogService.findAll();
        List<BackBlog> backbloglist = new ArrayList<>();
        for(int i = 0;i <ls.size();i++) {
            BackBlog backBlog = new BackBlog();
                backBlog.setAuthor(ls.get(i).getAuthor());
                backBlog.setMessage(ls.get(i).getMessage());
                backBlog.setTags(ls.get(i).getTags());
                backBlog.setTitle(ls.get(i).getTitle());
//            System.out.println("组合成的backBlog = "+backBlog.toString());
            backbloglist.add(backBlog);
        }
//        System.out.println("asd = "+backbloglist);
        return new AsyncResult<>(backbloglist.toString());
    }


    /**
     * 2
     * 模糊查询 根据关键字去匹配title，只要是包含关键字title的blog都展示出来
     * @param title
     * @return
     */
    @ApiOperation(value = "根据title查询",notes = "模糊查询")
    @RequestMapping(value = "/searchByTitle/{title}", method=RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> findBlogsByTitleLike(@PathVariable("title") String title) {
        ListenableFuture<String> ls = blogService.findByTitleLike(title);
        return ls;
    }

    /**
     * 3
     * 模糊查询 根据关键字去匹配author，返回作者是author的所有bolg
     * @param author
     * @return
     */
    @ApiOperation(value = "根据author查询",notes = "模糊查询")
    @RequestMapping(value = "/searchByAuthor/{author}", method=RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> findBlogsByAuthorLike(@PathVariable("author") String author) {
        ListenableFuture<String> ls = blogService.findByAuthorLike(author);
        return ls;
    }

    /**
     * 4
     * 模糊查询 根据关键字去匹配tags，返回tags相同的的所有bolg
     * @param tags
     * @return
     */
    @ApiOperation(value = "根据tags查询",notes = "模糊查询")
    @RequestMapping(value = "/searchByTags/{tags}", method=RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public ListenableFuture<String> findBlogsByTagsLike(@PathVariable("tags") String tags) {
        ListenableFuture<String> ls = blogService.findByTagsLike(tags);
        return ls;
    }


    /**
     * 5
     * 功能描述: 保存blog，就是新增加一条blog
     *
     * @param:  body:{'title':'savetest','tags':'b','author':'mac','message':'test save'}
     * @return:
     * @auther:
     * @date:
     */
    @ApiOperation(value = "添加一个新的blog",notes = "{'title':'','tags':'','author':'','message':''}")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public String save(@RequestBody String body){
        System.out.println("body = "+body);
        JSONObject obj = new JSONObject(body);
        System.out.println("title = "+obj.getString("title"));
        Blog blog = new Blog(obj.getString("title"),obj.getString("tags"),obj.getString("author"),obj.getString("message"));
        blogService.save(blog);
        return "save success";
    }


    /**
     * 6
     * 功能描述: 删除指定的blog
     *
     * @param:
     * @return:
     * @auther:
     * @date:
     */
    @ApiOperation(value = "删除指定blog",notes = "根据id")
    @RequestMapping(value = "/delect/{idblog}",method = RequestMethod.GET)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public String delect(@PathVariable int idblog){
        blogService.delectById(idblog);
        return "delect success";
    }



    /**
     * 7
     * 功能描述: 修改博客信息(修改是不能修改作者的，所以请求体body中是没有author的参数的)
     *
     * @param: body = "{'idblog':6,'title':'updatetest','tags':'b','message':'test updatepost'}"
     * @return:
     * @auther:
     * @date:
     */
    @ApiOperation(value = "更改指定的blog",notes = "更改信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @Async("asyncServiceExecutor")
    @ResponseBody
    public String update(@RequestBody String body){
        System.out.println("body = "+body);
        JSONObject js = new JSONObject(body);
        blogService.update(js.getInt("idblog"),js.getString("title"),js.getString("tags"),js.getString("message"));
        return "update success";
    }
}
