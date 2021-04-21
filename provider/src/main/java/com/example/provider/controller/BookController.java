package com.example.provider.controller;

import com.example.common.entity.Book;
import com.example.provider.service.BookService;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 书控制层
 *
 * @author 张庆福
 * @date 2021-04-22 00:26:22
 */
@Api(tags = "书接口")
@Slf4j
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param book 查询实体
     * @return 分页数据
     */
    @ApiOperation("分页查询所有数据")
    @GetMapping
    public R<Page<Book>> selectAll(Page<Book> page, Book book) {
        return R.ok(bookService.page(page, new QueryWrapper<>(book)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public R<Book> selectOne(@PathVariable Serializable id) {
        return R.ok(bookService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param book 实体对象
     * @return id
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R<Long> insert(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        if (flag) {
            return R.ok(book.getId());
        }
        return R.failed("新增失败");
    }

    /**
     * 根据id修改数据
     *
     * @param book 实体对象
     * @return id
     */
    @ApiOperation("根据id修改数据")
    @PutMapping
    public R<?> update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        if (flag) {
            return R.ok(book.getId());
        }
        return R.failed("修改失败");
    }

    /**
     * 单条/批量删除数据
     *
     * @param ids 主键集合
     */
    @ApiOperation("单条/批量删除数据")
    @DeleteMapping
    public R<?> delete(@RequestParam List<Long> ids) {
        boolean flag = bookService.removeByIds(ids);
        if (flag) {
            return R.ok(null);
        }
        return R.failed("删除失败");
    }
}
