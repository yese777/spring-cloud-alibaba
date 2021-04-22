package com.example.consumer.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.entity.Book;
import com.example.common.feign.BookFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 测试使用feign调用curd接口
 *
 * @author 张庆福
 * @date 2021/4/22
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BookFeignClient bookFeignClient;

    /**
     * 查询所有数据
     */
    @GetMapping("/book")
    public R<Page<Book>> selectAll(Page<Book> page) {
        return bookFeignClient.selectAll(page.getCurrent(), page.getSize());
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("/book/{id}")
    public R<Book> selectOne(@PathVariable("id") Serializable id) {
        return bookFeignClient.selectOne(id);
    }

    /**
     * 新增数据
     */
    @PostMapping("/book")
    public R<Long> insert(@RequestBody Book book) {
        return bookFeignClient.insert(book);
    }

    /**
     * 根据id修改数据
     */
    @PutMapping("/book")
    public R<Long> update(@RequestBody Book book) {
        return bookFeignClient.update(book);
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping("/book")
    public R<?> delete(@RequestParam("ids") List<Long> ids) {
        return bookFeignClient.delete(ids);
    }


}
