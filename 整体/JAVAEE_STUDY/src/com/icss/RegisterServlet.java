package com.icss;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取请求参数 请求对象 HttpServletRequest request
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        System.out.println("姓名"+uname+"密码"+pwd);
//        request.getParameterValues("name属性") 返回String[] 数组  获取前端页面同一个name属性对应的
        String[] hs = request.getParameterValues("hobby");
        if(hs!=null&&hs.length!=0){
            for (String i:hs) {
                System.out.println("选择的爱好"+i);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        System.out.println("姓名"+uname+"密码"+pwd);
//        request.getParameterValues("name属性") 返回String[] 数组  获取前端页面同一个name属性对应的
        String[] hs = request.getParameterValues("hobby");
        if(hs!=null&&hs.length!=0){
            for (String i:hs) {
                System.out.println("选择的爱好"+i);
            }
        }
    }
}
