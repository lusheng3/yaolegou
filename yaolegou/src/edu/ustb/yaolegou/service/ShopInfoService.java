package edu.ustb.yaolegou.service;


import edu.ustb.yaolegou.dao.ShopInfoMapper;
import edu.ustb.yaolegou.entity.ShopInfo;
import edu.ustb.yaolegou.entity.ShopInfoVO;
import edu.ustb.yaolegou.entity.ShopMingxi;
import edu.ustb.yaolegou.utils.MybatisUtil;
import edu.ustb.yaolegou.utils.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ShopInfoService {

    public ArrayList<ShopInfo> getAll(){
        ArrayList<ShopInfo> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
            list = siMapper.selectAll();

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

    public PageBean<ShopInfo> getPage(PageBean<ShopInfo> pageBean, ShopInfoVO siv){
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
            //获取总记录数
            pageBean.setTotalRecord(siMapper.selectCountByCondition(siv));
            //计算总页数
            int pageCnt = pageBean.getTotalRecord()/ pageBean.getPageRecord();
            if(pageBean.getTotalRecord() % pageBean.getPageRecord() > 0){
                pageCnt++;
            }
            pageBean.setPageCount(pageCnt);
            //
            int begin = (pageBean.getPageIndex()-1) * pageBean.getPageRecord();

            pageBean.setResultList(siMapper.queryPageByCondition(begin, pageBean.getPageRecord(), siv));

        }   catch(Exception e){
            e.printStackTrace();
        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return pageBean;
    }

    public ShopInfo selectById(int id){
        ShopInfo result = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
            result = siMapper.selectById(id);

        }   catch(Exception e){
            e.printStackTrace();
        }finally{
            //资源释放
            if(session != null){
                session.close();
            }
        }

        return result;
    }

    public List<ShopMingxi> selectAllMingxi(int id){
        List<ShopMingxi> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSession();
            ShopInfoMapper siMapper = session.getMapper(ShopInfoMapper.class);
            list = siMapper.selectAllMingxi(id);

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
}
