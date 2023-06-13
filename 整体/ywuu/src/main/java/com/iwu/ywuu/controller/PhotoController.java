package com.iwu.ywuu.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class PhotoController {
    @PostMapping("/updateImage")
    public String uploadImg(MultipartFile file,String a,HttpServletRequest req) throws IOException {
//        文件路径、文件名、返回值为访问路径
        System.out.println(a);
        String name = file.getName();
        String newname = UUID.randomUUID().toString()+name;
        String filepath = "D:\\Project\\Yiwu-online-sales\\整体\\ywuu\\src\\main\\resources\\static\\uploadFile\\"+newname;
        file.transferTo(new File(filepath));
        String filePath1 = req.getScheme() + "://" + req.getServerName() + ":" +
                req.getServerPort() + "/uploadFile/"+ newname;
        return filePath1 ;
    }

}
