package com.example.consumer.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.entity.Book;
import com.example.common.feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author 张庆福
 * @date 2021/4/22
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private Client client;

    @GetMapping("/test")
    public void aa() {
        R<List<Book>> listR = client.selectAll(null);
        log.info("result:[{}]", listR);
    }

}
