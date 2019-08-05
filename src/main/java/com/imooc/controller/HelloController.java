package com.imooc.controller;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private MessageDao dao = new MessageDao();

    @GetMapping("/hello")
    public String say() {
        return "Hello Spring Boot!";
    }

    @GetMapping("test")
    public List<Message> test(String command, String description) {
        return dao.queryMessageList(command, description);
    }
}
