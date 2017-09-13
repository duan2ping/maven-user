package com.duan2ping.my.controller;
import com.duan2ping.my.UserService;
import com.duan2ping.my.dao.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 用户请求处理
 * Created by duan2ping on 2017/9/11.
 */
@WebServlet("/user")
public class UserController extends HttpServlet{

    UserService service = new UserServiceImpl();

    // 执行请求
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ulist",service.query());
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
