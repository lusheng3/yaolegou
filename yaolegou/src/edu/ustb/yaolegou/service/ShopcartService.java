package edu.ustb.yaolegou.service;

import edu.ustb.yaolegou.dao.ShopcartMapper;
import edu.ustb.yaolegou.entity.Shopcart;
import edu.ustb.yaolegou.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class ShopcartService {
    /**
     *加入购物车
     * @param sc
     * @return
    */
    public int shopcartItemAdd(Shopcart sc){
        SqlSession session = null;
        int result = 0;

        try {
            session = MybatisUtil.getSession();
            ShopcartMapper scMapper = session.getMapper(ShopcartMapper.class);
            Shopcart shopcart = scMapper.selectByUserNameAndShopId(sc);
;           if(shopcart == null){
            //判断购物车中是否有该商品
               result = scMapper.insert(sc);
            }else{
                shopcart.setCount(shopcart.getCount()+sc.getCount());
                result = scMapper.updateCnt(shopcart);
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

        public int delete(int id){
            int result = 0;
            SqlSession session = null;
            try{
                session = MybatisUtil.getSession();
                ShopcartMapper scMapper = session.getMapper(ShopcartMapper.class);
                result = scMapper.delete(id);
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
                session.rollback();
            }finally {
                if(session != null){
                    session.close();
                }
            }
            return result;
        }

        public ArrayList<Shopcart> queryByUserName(String userName){
            ArrayList<Shopcart> list = null;
            SqlSession session = null;

            try {
                session = MybatisUtil.getSession();
                ShopcartMapper scMapper = session.getMapper(ShopcartMapper.class);
                list = scMapper.queryByUserName(userName);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(session != null){
                    session.close();
                }
            }
            return list;
        }

        public int updateCnt(int id, int cnt){
            int result = 0;
            SqlSession session = null;
            Shopcart shopcart = new Shopcart();
            shopcart.setId(id);
            shopcart.setCount(cnt);
            try {
                session = MybatisUtil.getSession();
                ShopcartMapper scMapper = session.getMapper(ShopcartMapper.class);
                result = scMapper.updateCnt(shopcart);
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
                session.rollback();
            }finally {
                if(session != null){
                    session.close();
                }
            }
            return result;
        }

}
