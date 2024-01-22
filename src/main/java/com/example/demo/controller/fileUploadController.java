package com.example.demo.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class fileUploadController {

    @PostMapping("/upload")
    public String upLoad(String nickName, MultipartFile photo, HttpServletRequest request) throws IOException{
        System.out.println(nickName);
        //获取文件原始名称
        System.out.println(photo.getOriginalFilename());
        //获取文件类型
        System.out.println(photo.getContentType());

        ServletContext context = request.getServletContext();
        String uploadPath = context.getRealPath("/upload/");

        System.out.println(uploadPath);
        saveFile(photo,uploadPath);

        return "upload success";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException{
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }

}
