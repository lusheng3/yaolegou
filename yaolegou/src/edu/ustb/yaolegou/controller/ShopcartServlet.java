package edu.ustb.yaolegou.controller;

import edu.ustb.yaolegou.entity.*;
import edu.ustb.yaolegou.service.OrderInfoService;
import edu.ustb.yaolegou.service.ShopInfoService;
import edu.ustb.yaolegou.service.ShopcartService;
import edu.ustb.yaolegou.utils.UUIDUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@WebServlet(name = "ShopcartServlet", value = "/shopcart")
public class ShopcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String State = request.getParameter("State");
        ShopcartService scService = new ShopcartService();
        OrderInfoService oiService = new OrderInfoService();
        ShopInfoService siService = new ShopInfoService();
        if (State == null) {
            String userName = request.getParameter("UserName");
            List<Shopcart> scList = scService.queryByUserName(userName);
            request.setAttribute("userName", userName);
            request.setAttribute("itemList", scList);
            request.getRequestDispatcher("/shopcart.jsp").forward(request, response);

        } else if (State.equals("del")) {
            String userName = request.getParameter("username");
            String id = request.getParameter("id");
            int result = scService.delete(Integer.parseInt(id));
            response.getWriter().print(result > 0);
        } else if (State.equals("updateCnt")) {
            //添加购物车信息
            String username = request.getParameter("usename");
            String id = request.getParameter("id");
            String shopid = request.getParameter("shopid");
            String count = request.getParameter("count");
            int result = scService.updateCnt(Integer.parseInt(id), Integer.parseInt(count));
            response.getWriter().print(result > 0);
        } else if (State.equals("submit")) {
/**
 * 前往订单页面
 */
            String UserName = request.getParameter("UserName");
            List<SHAddress> shAddrList = oiService.queryAddrByUsername(UserName);

            OrderInfo orderInfo = oiService.queryOrderByUsername(UserName);
            int totalCnt = 0;
            double totalPrice = 0;
            if (orderInfo == null) {
                orderInfo = new OrderInfo();
                orderInfo.setDingdanNumber(UUIDUtil.getUUID());
                orderInfo.setUserName(UserName);
                orderInfo.setZhuRenUser(UserName);
                //处理订单
                String[] id = request.getParameterValues("ids");//接收一组商品的默认id
                String[] shopid = request.getParameterValues("shopid");    //接收一组商品id
                String[] shangpincount = request.getParameterValues("shangpincount");    //接受一组商品数量
                String[] shangpincolor = request.getParameterValues("shangpincolor");    //接受一组商品颜色
                String[] shangpinchicun = request.getParameterValues("shangpinchicun");    //接受一组商品尺寸
                String[] username = request.getParameterValues("usernames");    //接受一组商品名称

                //往订单详情商品表里面插入数据
                OrderItem orderItem;
                orderInfo.setItemList(new ArrayList<OrderItem>());
                for (int i = 0; i < shangpinchicun.length; i++) {
                    if (!shangpinchicun[i].equals("")) {
                        orderItem = new OrderItem();
                        orderItem.setChiCun(shangpinchicun[i]);
                        orderItem.setColor(shangpincolor[i]);
                        int count = Integer.parseInt(shangpincount[i]);
                        orderItem.setCount(count);
                        orderItem.setDingdanNumber(orderInfo.getDingdanNumber());
                        orderItem.setShopId(Integer.parseInt(shopid[i]));
                        orderItem.setUserName(username[i]);
                        orderItem.setMyUser(UserName);
                        orderItem.setSi(siService.selectById(orderItem.getShopId()));
                        orderInfo.getItemList().add(orderItem);
                        totalCnt += count;
                        totalPrice += orderItem.getSi().getShopPrice() * count;
                    }
                }
                orderInfo.setPrice(totalPrice);
                //订单数据添加
                oiService.orderAdd(orderInfo);

                //查询全部插入的数据
//            List<DingDanXiangQing> list = ddxqd.ByUserNameAndDingDanNumberGetInfo(UserName, DingDanNumber);
//            for (DingDanXiangQing dingDanXiangQing : list) {
//                System.out.println(dingDanXiangQing.getUsername() + "  " + dingDanXiangQing.getDingdannumber());
//            }

            } else {
                for (OrderItem item :
                        orderInfo.getItemList()) {
                    totalCnt += item.getCount();
                    totalPrice += item.getSi().getShopPrice() * item.getCount();
                }
            }

            List<Province> proList = oiService.queryAllProvince();
            List<PayType> ptList = oiService.queryAllPayType();

            //订单详情表里面的信息
            request.setAttribute("list", orderInfo.getItemList());

            request.setAttribute("ZhiFuTypeList", ptList);
            request.setAttribute("ShengList", proList);
            request.setAttribute("ShouHuolist", shAddrList);
            request.setAttribute("UserName", UserName);
            request.setAttribute("totalCnt", totalCnt);
            request.setAttribute("orderInfo", orderInfo);
            request.getRequestDispatcher("/order.jsp").forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


