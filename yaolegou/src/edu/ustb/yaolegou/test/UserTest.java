package edu.ustb.yaolegou.test;


import edu.ustb.yaolegou.dao.OrderInfoMapper;
import edu.ustb.yaolegou.dao.ShopInfoMapper;
import edu.ustb.yaolegou.dao.ShopcartMapper;
import edu.ustb.yaolegou.dao.UserMapper;
import edu.ustb.yaolegou.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UserTest {
    private SqlSession session = null;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();

    }

    @After
    public void after() throws IOException {
        session.close();

    }

    @Test
    public void testSelectByName() throws IOException{
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByName("123456");
        System.out.println(user);
    }
//    @Test
//    public void testQueryPageByCondition() throws IOException{
//        ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
//        ShopInfoVO shopInfoVO = new ShopInfoVO();
//        shopInfoVO.setSexFenlei("男");
//        shopInfoVO.setSizeFenlei("大码");
//        ArrayList<ShopInfo> list = siMapper.queryPageByCondition(shopInfoVO);
//        System.out.println(list);
//    }
    @Test
    public void testShopcart() throws IOException{
        ShopcartMapper scMapper = session.getMapper(ShopcartMapper.class);
        Shopcart sc = new Shopcart();
        sc.setShopId(18);
        sc.setUserName("45078733");
        sc.setShopName("MAIDEXI迈得喜 时尚纯色弹力休闲男士长袖圆领修身T恤上衣 秋冬青年韩版小清新打底衫");
        sc.setColor("浅灰色");
        sc.setChiCun("M");
        sc.setCount(2);
        sc.setPrice(47);
        sc.setImage("attached/image/18_fengmian.jpg");

        scMapper.insert(sc);
        session.commit();
    }

//    @Test
//    public void updateState(String orderNum, int stateId){
//        int result = 0;
//        OrderInfoMapper oiMapper = session.getMapper(OrderInfoMapper.class);
//        result = oiMapper.updateState("123",1);
//        session.commit();
//        System.out.println(result);
//
//    }
}
