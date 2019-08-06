package com.imooc.controller;

import com.imooc.bean.Message;
import com.imooc.entity.Page;
import com.imooc.service.QueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private QueryService listService = new QueryService();

    @GetMapping("/hello")
    public String say() {
        return "Hello Spring Boot!";
    }

    @GetMapping("test")
    public List<Message> test(String command, String description, String pageNo) {
        //创建分页对象
        Page page = new Page();
        if (pageNo == null) {
            page.setPageNo(1);
        } else {
            page.setPageNo(Integer.valueOf(pageNo));
        }
        return listService.queryMessageListByPage(command, description, page);
    }


}
