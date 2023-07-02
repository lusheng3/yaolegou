package edu.ustb.yaolegou.controller;


import edu.ustb.yaolegou.entity.Banner;
import edu.ustb.yaolegou.entity.User;
import edu.ustb.yaolegou.service.BannerService;
import edu.ustb.yaolegou.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "HelloServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        BannerService bannerService = new BannerService();
        //获取数据
        ArrayList<Banner> list = bannerService.getAll();
        //放入request域
        request.setAttribute("BannerList",list);
        //转发到index页
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        UserService userService = new UserService();

        String name = request.getParameter("UserName");
        String pwd = request.getParameter("PassWord");

        User user = new User();
        user.setUserName(name);
        user.setPassword(pwd);

        String result = userService.login(user);
        if("true".equals(result)){
            //加载完整user数据
            user = userService.getUserByName(user.getUserName());
            request.getSession(true).setAttribute("user",user);

        }


        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();

    }
}
