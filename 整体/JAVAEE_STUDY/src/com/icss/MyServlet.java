package com.icss;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet extends HttpServlet {
    public MyServlet() {
        System.out.println("myservlet的构造方法");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("myservlet的初始化");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法的调用");
       // super.service(req, resp);
        String method = req.getMethod();
        if("GET".equals(method)){
            doGet(req, resp);
        }else if("POST".equals(method)){
            doPost(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("myservlet的销毁");
        super.destroy();
    }
}
