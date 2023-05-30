package com.iwu.ywuu.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.iwu.ywuu.entity.User;
import com.iwu.ywuu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//说明它是一个controller 返回值是json类型
@RequestMapping("/user")//设置请求路径
public class UserController {
    @Autowired
    UserService userService;

    //登录的时候不可以把账号和密码显示出来 所以一定要用post请求
    @PostMapping("/login")
    public JSON userLog(@RequestBody User user) {
        JSONObject obj = JSONUtil.createObj();
        if (user.getUaccount() !="" && user.getUpassword() != "") {
            Boolean aBoolean = userService.loginUser(user.getUaccount(), user.getUpassword());
            if (aBoolean) {
                obj.set("status", "200");
                obj.set("msg", "success");
            } else {
                obj.set("status", "400");
                obj.set("msg", "fail");
            }
        } else {
            obj.set("status", "400");
            obj.set("msg", "fail");
        }
        return obj;
    }

    //注册
    @PostMapping("/regist")
    public JSON userNew(@RequestBody User user){
        JSONObject obj = JSONUtil.createObj();
        if(user.getUid()!=0&&user.getUaccount()!=""&&user.getUpassword()!=""&&user.getUname()!=""){
        Boolean aBoolean = userService.addNewUser(user.getUid(), user.getUaccount(), user.getUpassword(), user.getUname());
        if (aBoolean) {
            obj.set("status", "200");
            obj.set("msg", "success");
        } else {
            obj.set("status", "400");
            obj.set("msg", "fail");
        }
        return obj;
        }else{
            obj.set("status", "400");
            obj.set("msg", "fail");
            return obj;
        }
    }
//修改密码
    @PostMapping("/newp")
    public JSON getNewPassword(@RequestBody User user){
        JSONObject obj = JSONUtil.createObj();
        if(user.getUid()!=0&&user.getUaccount()!=""&&user.getUpassword()!=""&&user.getUname()!=""){
            Boolean aBoolean = userService.updateNewPw(user.getUid(), user.getUaccount(),user.getUpassword());
            if(aBoolean){
                obj.set("status","200");
                obj.set("msg","success");
                return obj;
            }else{
                obj.set("status","400");
                obj.set("msg","fail");
                return obj;
            }
        }else{
            obj.set("status","400");
            obj.set("msg","fail");
            return obj;
        }
    }
}
