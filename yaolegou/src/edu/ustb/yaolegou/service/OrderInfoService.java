package edu.ustb.yaolegou.service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import edu.ustb.yaolegou.dao.BannerMapper;
import edu.ustb.yaolegou.dao.OrderInfoMapper;
import edu.ustb.yaolegou.dao.ShopInfoMapper;
import edu.ustb.yaolegou.entity.*;
import edu.ustb.yaolegou.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoService {
    public int orderAdd(OrderInfo orderInfo){
        SqlSession session = null;
        int result = 0;
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            result =oiMapper.insert(orderInfo);
            if(result > 0){
                for(OrderItem item : orderInfo.getItemList()){
                    result=oiMapper.insertItem(item);
                }
            }
            session.commit();
        }   catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return result;
    }
    /**
     * 查询用户未支付订单
     * @param userName
     * @return
     */
    public OrderInfo queryOrderByUsername(String userName){
        OrderInfo orderInfo = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
            orderInfo =oiMapper.selectByUserName(userName);
            if(orderInfo != null){
                List<OrderItem> list = oiMapper.selectItemByNumber(orderInfo.getDingdanNumber());
                for(OrderItem item : list){
                    item.setSi(siMapper.selectById(item.getShopId()));
                }
                orderInfo.setItemList(oiMapper.selectItemByNumber(orderInfo.getDingdanNumber()));
            }

        }   catch(Exception e){
            e.printStackTrace();

        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return orderInfo;
    }
    public List<SHAddress> queryAddrByUsername(String userName){
        List<SHAddress> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            list =oiMapper.queryAddrByUsername(userName);



        }   catch(Exception e){
            e.printStackTrace();

        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return list;
    }

////    public List<OrderState> queryAllOrderState(){
////        List<OrderState> list = null;
////        SqlSession session = null;
////        try {
////            session = MybatisUtil.getSession();
////            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
////            list =oiMapper.queryAllO(userName);
////
////
////
////        }   catch(Exception e){
////            e.printStackTrace();
////
////        }finally{
////            //资源释放
////            if(session != null){
////                session.close();
////            }
////        }
////
////        return list;
////    }
    public List<PayType> queryAllPayType(){
        List<PayType> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            list =oiMapper.queryAllPayType();



        }   catch(Exception e){
            e.printStackTrace();

        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return list;
    }
    public List<Province> queryAllProvince(){
        List<Province> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            list =oiMapper.queryAllProvince();


        }   catch(Exception e){
            e.printStackTrace();

        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return list;
    }
//    public Province queryProvinceByName(String name){
//
//    }
//
//    public City queryCityByName(String name){
//
//    }
//    public List<City> queryCityByProvId(int id){
//
//    }
//    public List<District> queryDistrictByCityId(int id){
//
//    }

    public int updateState(String orderNum, int stateId){
        SqlSession session = null;
        int result = 0;
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDingdanNumber(orderNum);
        orderInfo.setStateId(stateId);
        try {
            session = MybatisUtil.getSession();
            OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
            result =oiMapper.updateState(orderInfo);

            session.commit();
        }   catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return result;
    }
}
