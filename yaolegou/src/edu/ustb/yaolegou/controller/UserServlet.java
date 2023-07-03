package edu.ustb.yaolegou.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ustb.yaolegou.entity.User;
import edu.ustb.yaolegou.service.UserService;
import edu.ustb.yaolegou.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "UserServlet",value = "/reg")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*PrintWriter out = response.getWriter();*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String State = request.getParameter("State");
        String phone = request.getParameter("phone");
        if(State == null){
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("/reg2.jsp").forward(request, response);
        }else if(State.equals("add")){
            //获取手机号和密码
            String pwd = request.getParameter("pwd");

            //生成八位随机数
            Random random = new Random();
            int suiji = random.nextInt(99999999);
            String UserName = suiji+"";

            //赋值
            User u = new User();
            u.setUserName(UserName);
            u.setPassword(pwd);
            u.setPhone(phone);

            //随机生成网名
            String[] name1 = new String[]{"最帅的","好看的","美丽的","会撩妹的","爱玩快手的","可爱的","爱听音乐的","爱斗图的","细心的","爱玩抖音的"};
            String[] name2 = new String[]{"小红","小仙女","小清新","郭德纲","小白","翠花","熊大","熊二","光头强","老崔"};
            int n1 = random.nextInt(10);
            int n2 = random.nextInt(10);
            String UserNick = name1[n1]+name2[n2];

            u.setUserNick(UserNick);

//       //执行增加用户
//       boolean is = ud.AddUserNameInfo(u);
            userService.userAdd(u);
            response.getWriter().print(UserName);
        }else if(State.equals("yanzhengs")){
            User user = userService.getUserByPhone(phone);
            response.getWriter().print(user == null);
        }else if(State.equals("sendsms")){
            String code = CheckCodeUtil.getCode(6);
            String result = userService.sendSms(phone, code);
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, String> rst = objMapper.readValue(result, Map.class);
            if("OK".equals(rst.get("Code"))){
                request.getSession().setAttribute("smsCode", code);
                response.getWriter().print("true");
            }
        }else if(State.equals("checksms")){
            String code = request.getParameter("smscode");
            response.getWriter().print(code.equals(request.getSession().getAttribute("smsCode")));
        }

    }

}

