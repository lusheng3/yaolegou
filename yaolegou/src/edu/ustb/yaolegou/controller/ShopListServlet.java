package edu.ustb.yaolegou.controller;

import edu.ustb.yaolegou.entity.ShopInfo;
import edu.ustb.yaolegou.entity.ShopInfoVO;
import edu.ustb.yaolegou.service.ShopInfoService;
import edu.ustb.yaolegou.utils.PageBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShopListServlet", value = "/shoplist")
public class ShopListServlet extends HttpServlet {
    ShopInfoService shopInfoService = new ShopInfoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter out = response.getWriter();*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String State = request.getParameter("State");
        if(State == null){
            //分页
            PageBean<ShopInfo> pb = new PageBean<>();
            String page = request.getParameter("page");
            if(page != null && !page.equals("")){
                pb.setPageIndex(Integer.parseInt(page));
            }else{
                pb.setPageIndex(1);
            }
            pb.setPageRecord(20);
            //接受性别分类
            String SexFenLei = request.getParameter("SexFenLei");
            String ma = request.getParameter("ma");
            String banxing = request.getParameter("banxing");
            String s = request.getParameter("s");
            String b = request.getParameter("b");
            ShopInfoVO siv = new ShopInfoVO();
            //进行判断
            if(SexFenLei != null && !SexFenLei.equals("全")){
                siv.setSexFenlei(SexFenLei);
            }
            if(ma != null && !ma.equals("部")){
                siv.setSizeFenlei(ma);
            }
            if(banxing != null && !banxing.equals("全部")){
                siv.setBanxingFenlei(banxing);
            }

            pb = shopInfoService.getPage(pb,siv);
            request.setAttribute("SexFenLei", SexFenLei);
            request.setAttribute("ma", ma);
            request.setAttribute("banxing", banxing);
            request.setAttribute("s", s);
            request.setAttribute("b", b);
            //request.setAttribute("si", si);
            request.setAttribute("pb", pb);
            request.getRequestDispatcher("/shoplist.jsp").forward(request, response);
        }else if(State.equals("Select")){
//            /**
//             * 通往物品详情
//             */
//            String ShopId = request.getParameter("ShopId");
//
//            ShopInfo si = shopInfoService.selectById(Integer.parseInt(ShopId));
//
//            String color = si.getColor();
//            String[] Color = color.split(",");
//
//            String chicun = si.getChiCun();
//            String[] ChiCun = chicun.split(",");
//
//            List<ShopMingxi> ShopMingXiList = shopInfoService.selectAllMingxi(Integer.parseInt(ShopId));
//            //       UserInfoDao uid = new UserInfoDaoImpl();
////       UserInfo ui = uid.ByUserNameGetInfo(si.getZhuRenUser());
////
////       PingLunDao pld = new PingLunDaoImpl();
////       List<PingLun> plList = pld.ByShopIdGetAllInfo(Integer.parseInt(ShopId));
////
////       request.setAttribute("plList", plList);
////       request.setAttribute("ui", ui);
//            request.setAttribute("ChiCun", ChiCun);
//            request.setAttribute("Color", Color);
//            request.setAttribute("ShopMingXiList", ShopMingXiList);
//            request.setAttribute("si", si);
//            request.getRequestDispatcher("/shopdetail.jsp").forward(request, response);
        }else if(State.equals("AddInfo")){

//       String MyUser = request.getParameter("MyUser");
//       String ziji = request.getParameter("ziji");
//       String context = request.getParameter("context");
//       String shopid = request.getParameter("shopid");
//       PingLunDao pld = new PingLunDaoImpl();
//
//       PingLun pl = new PingLun();
//       pl.setContext(context);
//       pl.setMyuser(MyUser);
//       pl.setUsername(ziji);
//       pl.setShopid(Integer.parseInt(shopid));
//
//       boolean is = pld.AddPingLunInfo(pl);
//
//       UserInfoDao uid = new UserInfoDaoImpl();
//       UserInfo ui = uid.ByUserNameGetInfo(MyUser);
//
//       response.getWriter().print(ui);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
