package edu.ustb.yaolegou.dao;

import edu.ustb.yaolegou.entity.Shopcart;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ShopcartMapper {
    //根据userName获取购物车列表
    @Select("select * from gouwuche where UserName=#{userName}")
    public ArrayList<Shopcart> queryByUserName(@Param("userName") String username);
    @Select("select * from gouwuche where UserName=#{userName} and ShopId = #{shopId} and ChiCun = #{chiCun} and Color=#{color}")
    public Shopcart selectByUserNameAndShopId(Shopcart shopcart);
    //insert
    @Insert("INSERT INTO `gouwuche`(`UserName`,`ShopName`,`ChiCun`,`Color`,`Count`,`Price`,`Image`,`ShopId`)" +
            "VALUES (#{userName},#{shopName},#{chiCun},#{color},#{count},#{price},#{image},#{shopId})" )
    public int insert(Shopcart shopcart);
    //update商品数量
    @Update("update gouwuche set count=#{count} where id=#{id}")
    public int updateCnt(Shopcart shopcart);

    //deleteById
    @Delete("delete from gouwuche where id=#{id}")
    public int delete(int id);
}
