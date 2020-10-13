package com.example.kevinzhou.demo.controller;


import com.example.kevinzhou.demo.constant.Book;
import com.example.kevinzhou.demo.model.ResetPsdRequest;
import com.example.kevinzhou.demo.model.ResponseBase;
import com.example.kevinzhou.demo.user.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("test1")
    public Object test1(){
        return "hello";
    }

}
