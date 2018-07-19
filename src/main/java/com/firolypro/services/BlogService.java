package com.firolypro.services;

import com.firolypro.dataobj.Blog;
import com.firolypro.dataobj.Users;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.services
 * lihaoyang
 * 2018/6/21
 * 上午11:14
 **/
public interface BlogService {
/**
 * 功能描述: 前4个查询方法主要是用来展示blog信息的，可以用于首页展示，个人展示等功能，
 *         现阶段先把所有的blog存放到一个blog表中。
 *         （不知道这个思路对不对，微博那么大的体量肯定不是这么存储的）
 */
    //查找所有的数据
    List<Blog> findAll();
    //模糊查询(根据title)
    ListenableFuture<String> findByTitleLike(String title);
    //模糊查询(根据Author)
    ListenableFuture<String> findByAuthorLike(String author);
    //模糊查询(根据Tags)
    ListenableFuture<String> findByTagsLike(String tags);

//
//
    //添加一个user  增
    Blog save(Blog blog);

//
    //查找一个特定的实例  查
    Blog findOneById(int id);
//
//
//    //修改一个实例的属性   改
    Blog update(int id,String title,String tags,String message);
//

    //删除指定实例      删
    void delectById(int id);
}
