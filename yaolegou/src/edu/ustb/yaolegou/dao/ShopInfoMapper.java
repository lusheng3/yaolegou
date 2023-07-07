package edu.ustb.yaolegou.dao;

import edu.ustb.yaolegou.entity.ShopInfo;
import edu.ustb.yaolegou.entity.ShopInfoVO;
import edu.ustb.yaolegou.entity.ShopMingxi;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ShopInfoMapper {
    @Select("select * from shopinfo where shopId = #{id}")
    public ShopInfo selectById(int id);

    @Select("select * from shopinfo")
    public ArrayList<ShopInfo> selectAll();

    @Select("select count(1) from shopinfo")
    public int selectCount();

    @Select("<script>"+
            "select count(1) from shopinfo where true"+
            "<if test='sexFenlei!=null'> and shopname like concat('%',#{sexFenlei},'%')</if>"+
            "<if test='sizeFenlei!=null'> and shopname like concat('%',#{sizeFenlei},'%')</if>"+
            "<if test='banxingFenlei!=null'> and shopname like concat('%',#{banxingFenlei},'%')</if>"+
            "</script>")
    public int selectCountByCondition(ShopInfoVO siv);

    @Select("select * from shopinfo limit #{begin}, #{count}")
    public ArrayList<ShopInfo> selectByPage(@Param("begin") int begin, @Param("count") int count);

    @Insert("INSERT INTO `yaolegoudb`.`shopinfo` (`ShopName`,`ShopMiaoShu`,`ShopPrice`,`ChiCun`,`Color`,`ZhuRenUser`,`ShopTypeId`,`Image`,`Context`,`XiaoLiangCount`)" +
            " VALUES(#{shopName},'',100,'',#{color},'',2,'','',0)")
    public int insert(ShopInfo shopInfo);

    @Update("UPDATE `shopinfo`SET `ShopName` = #{shopName},`Color` = #{color} WHERE `ShopId` = #{shopId}")
    public int update(ShopInfo shopInfo);

    @Delete("DELETE FROM `yaolegoudb`.`shopinfo` WHERE Shopid = #{id}")
    public int delete(int id);

    @Select("<script>"+
            "select * from shopinfo where true"+
            "<if test='siv.sexFenlei!=null'> and shopname like concat('%',#{siv.sexFenlei},'%')</if>"+
            "<if test='siv.sizeFenlei!=null'> and shopname like concat('%',#{siv.sizeFenlei},'%')</if>"+
            "<if test='siv.banxingFenlei!=null'> and shopname like concat('%',#{siv.banxingFenlei},'%')</if>"+
            "limit #{begin}, #{count}</script>")
    ArrayList<ShopInfo> queryPageByCondition(@Param("begin") int begin, @Param("count") int count,@Param("siv") ShopInfoVO siv);

    @Select("select * from shopmingxi where shopid = #{id}")
    public ArrayList<ShopMingxi> selectAllMingxi(int id);
}
