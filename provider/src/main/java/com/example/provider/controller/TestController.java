package com.example.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试动态刷新配置文件
 *
 * @author 张庆福
 * @date 2021/4/24
 */
@Slf4j
@RestController
// 另外，这里还有一个比较重要的注解@RefreshScope，主要用来让这个类下的配置内容支持动态刷新，也就是当我们的应用启动之后，修改了Nacos中的配置内容之后，这里也会马上生效。
@RefreshScope
public class TestController {

    @Value("${aa}")
    private String title;

    @GetMapping("/test")
    public String hello() {
        return title;
    }

}
