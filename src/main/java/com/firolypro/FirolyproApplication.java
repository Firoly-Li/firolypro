package com.firolypro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



/**
 *
 * 项目名称 ：firolypro
 * 作者： firoly
 *
 *
 * 已实现功能：
 *    1、login模块
 *          1.1 : 登录和注册功能
 *
 *    2、blog模块（针对个人管理，类似微博中'我的'）
 *          2.1 : blog的save功能
 *          2.2 : 获取全部blog的信息findAll功能
 *          2.3 : 模糊查询功能(title、tags、author)
 *          2.4 : blog的updata功能
 *          2.5 : 删除指定blog(根据id)
 *
 *    3、user模块(未开放接口，用于后台管理)
 *          3.1 : 获取所有的user
 *          3.2 : 新增一个user
 *          3.3 : 删除一个user
 *          3.4 : 查找指定user
 *          3.5 : 修改指定user信息(根据id)
 *
 * 未实现的功能：
// *    1、 blog首页（只做展示，不做修改）：
// *         1.1、： 模糊查询功能(title、tags、author)
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.firolypro"})
public class FirolyproApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirolyproApplication.class, args);
    }
}
