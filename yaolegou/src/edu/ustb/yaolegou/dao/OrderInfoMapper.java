package edu.ustb.yaolegou.dao;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import edu.ustb.yaolegou.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {
    //订单主信息根据 编号 查询
    @Select("select * from dingdanbiao where DingDanNumber=#{orderNum}")
    public OrderInfo selectByNumber(@Param("orderNum") String orderNum);

    @Select("select * from dingdanbiao where UserName=#{userName} and stateid=0")
    public OrderInfo selectByUserName(@Param("userName") String userName);

    //订单信息的 insert
    @Insert("INSERT INTO dingdanbiao (DingDanNumber,ZhuRenUser,Price,StateId,UserName,ZhiFuId,AddressId) "+
    "VALUES (#{dingdanNumber},#{zhuRenUser},#{price},#{stateId},#{userName},#{zhifuId},#{addressId})")
    public int insert(OrderInfo orderInfo);

    @Insert("update dingdanbiao set StateId=#{stateId} where DingDanNumber=#{dingdanNumber}")
    public int updateState(OrderInfo orderInfo);

    //订单详情的 insert select
    @Select("select * from dingdanxiangqing where DingDanNumber=#{orderNum}")
    public List<OrderItem> selectItemByNumber(@Param("orderNum") String orderNum);

    @Insert("INSERT INTO `dingdanxiangqing` (`DingDanNumber`,`ShopId`,`ChiCun`,`Color`,`count`,`UserName`,`MyUser`)" +
            "VALUES (#{dingdanNumber},#{shopId},#{chiCun},#{color},#{count},#{userName},0)")
    public int insertItem(OrderItem orderItem);

    //收获地址的 insert select
    @Insert("INSERT INTO `shaddress`(`UserName`,`Name`,`Phone`,`ByPhone`,`City`,`Address`)" +
            "VALUES (#{userName},#{name},#{phone},#{byPhone},#{city},#{address},0)")
    public int insertSHAddr(SHAddress shAddress);

    @Select("select * from shaddress where username=#{username}")
    public List<SHAddress> queryAddrByUsername(@Param("username") String userName);


    @Select("select * from _zhifutype")
    public List<PayType> queryAllPayType();

    @Select("select * from sheng")
    public List<Province> queryAllProvince();


}
