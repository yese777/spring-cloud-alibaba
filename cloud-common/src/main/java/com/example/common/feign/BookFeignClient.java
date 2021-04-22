package com.example.common.feign;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@FeignClient("demo-provider")
@Component
public interface BookFeignClient {

    /**
     * 查询所有数据
     */
    @GetMapping("/book")
    R<Page<Book>> selectAll(@RequestParam("current") Long current, @RequestParam("size") Long size);

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("/book/{id}")
    R<Book> selectOne(@PathVariable("id") Serializable id);

    /**
     * 新增数据
     */
    @PostMapping("/book")
    R<Long> insert(@RequestBody Book book);

    /**
     * 根据id修改数据
     */
    @PutMapping("/book")
    R<Long> update(@RequestBody Book book);

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping("/book")
    R<?> delete(@RequestParam("ids") List<Long> ids);


}
