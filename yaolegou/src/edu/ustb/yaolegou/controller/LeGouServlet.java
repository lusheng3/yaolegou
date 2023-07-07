package edu.ustb.yaolegou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LeGouServlet", urlPatterns = "/LeGou.do")
public class LeGouServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = request.getParameter("State");

        if ("Exit".equals(state)) {
// 执行退出账号的逻辑
// 例如使会话无效、清除认证凭据等
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

// 重定向到目标URL
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
// 处理其他的请求逻辑
        }
    }
}

