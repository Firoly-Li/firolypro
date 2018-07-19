package com.firolypro.repository;

import com.firolypro.dataobj.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * com.firolypro.repository
 * lihaoyang
 * 2018/6/21
 * 上午11:13
 **/
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<String> findByTitleLike(String title);
    List<String> findByTagsLike(String tags);
//    ListenableFuture<String> findByAuthorLike(String author);
    List<String> findByAuthorLike(String author);
}
