package com.example.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Book;
import com.example.provider.mapper.BookMapper;
import com.example.provider.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 书服务实现类
 *
 * @author 张庆福
 * @date 2021-04-22 00:26:22
 */
@Slf4j
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
