package com.example.demo.controller;
import com.example.demo.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {

    //  http://localhost:8080/hello?nickname=zhangsan
    @GetMapping("/hello")
    public String hello(String nickName){
        return "hello" + nickName;
    }

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public String postTest(String userName, String passWord){
        System.out.println("userName: " + userName);
        System.out.println("passWord: " + passWord);
        return "post请求";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(User user){
        System.out.println(user);
        return "post请求";
    }


}
