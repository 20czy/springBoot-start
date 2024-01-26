package com.example.demo.controller;

import com.example.demo.utils.Token;
import com.example.demo.entity.User;
import com.example.demo.entity.Traveller;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Result;

import java.util.List;

@RestController //方法的返回值会直接返回给http
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @PostMapping("/login")
   public Result login(@RequestBody Traveller traveller){
        System.out.println(traveller);
        // @RequestBody 如果前端传递的数据是json格式的必须用对象去接收，同时要添加@RequestBody
        String tokenKey = Token.generateToken(traveller.getUsername());
        return Result.ok().data("token",tokenKey);
    }

    @GetMapping("/info")
    public Result info(String token){
        String travellerName = Token.analyseKey(token).getSubject();
        System.out.println(travellerName);
        String url = "https://th.bing.com/th?id=OSK.6c0cc1959345baf7c6e5ae5c1458cc25&w=148&h=148&c=7&o=6&pid=SANGAM";
        return Result.ok().data("name",travellerName).data("avatar",url);
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/User")
    public List<User> query(){

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return users;
    }

    @PostMapping("/save")
    public String save(User user){
        int i = userMapper.insert(user);
        if (i > 0){
            return "插入成功";
        }
        else {
            return "插入失败";
        }

    }
    @PostMapping("/delete")
    public String delete(int id){
        int i = userMapper.deleteById(id);
        if (i > 0){
            return "删除成功";
        }
        else return "删除失败";
    }
}
