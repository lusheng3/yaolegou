package edu.ustb.yaolegou.controller;

import edu.ustb.yaolegou.entity.ShopInfo;
import edu.ustb.yaolegou.entity.ShopMingxi;
import edu.ustb.yaolegou.entity.Shopcart;
import edu.ustb.yaolegou.service.ShopInfoService;
import edu.ustb.yaolegou.service.ShopcartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopDetailServlet", value = "/shopdetail")
public class ShopDetailServlet extends HttpServlet {
    ShopInfoService shopInfoService = new ShopInfoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter out = response.getWriter();*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String State = request.getParameter("State");
        if (State == null){
            /**
             //             * 通往物品详情
             //             */
            String ShopId = request.getParameter("ShopId");

            ShopInfo si = shopInfoService.selectById(Integer.parseInt(ShopId));

            String color = si.getColor();
            String[] Color = color.split(",");

            String chicun = si.getChiCun();
            String[] ChiCun = chicun.split(",");

            List<ShopMingxi> ShopMingXiList = shopInfoService.selectAllMingxi(Integer.parseInt(ShopId));
            //       UserInfoDao uid = new UserInfoDaoImpl();
//       UserInfo ui = uid.ByUserNameGetInfo(si.getZhuRenUser());
//
//       PingLunDao pld = new PingLunDaoImpl();
//       List<PingLun> plList = pld.ByShopIdGetAllInfo(Integer.parseInt(ShopId));
//
//       request.setAttribute("plList", plList);
//       request.setAttribute("ui", ui);
            request.setAttribute("ChiCun", ChiCun);
            request.setAttribute("Color", Color);
            request.setAttribute("ShopMingXiList", ShopMingXiList);
            request.setAttribute("si", si);
            request.getRequestDispatcher("/shopdetail.jsp").forward(request, response);
        }else if(State =="color"){
            //            String shopid = request.getParameter("shopid");
//            String Color = request.getParameter("color");
//
//            ShopColorDao scd = new ShopColorDaoImpl();
//            List<ShopColor> ColorList = scd.ByShopIdAndColorGetAllInfo(Integer.parseInt(shopid), Color);
//
//            String Colors = JSON.toJSONString(ColorList);
//            response.getWriter().print(Colors);
//

        }else if(State.equals("add")){

            String img = request.getParameter("img");
            String shopid = request.getParameter("id");
            String shopname = request.getParameter("shopname");
            String yanse = request.getParameter("yanse");
            String chicun = request.getParameter("chicun");
            String jiage = request.getParameter("jiage");
            String count = request.getParameter("count");
            String UserName = request.getParameter("UserName");

            Shopcart sc = new Shopcart();
            sc.setImage(img);
            sc.setShopId(Integer.parseInt(shopid));
            sc.setShopName(shopname);
            sc.setColor(yanse);
            sc.setChiCun(chicun);
            sc.setPrice(Double.parseDouble(jiage));
            sc.setCount(Integer.parseInt(count));
            sc.setUserName(UserName);

            ShopcartService scService = new ShopcartService();
            int result = scService.shopcartItemAdd(sc);
            response.getWriter().print(result > 0);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
