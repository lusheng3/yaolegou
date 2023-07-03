package edu.ustb.yaolegou.dao;

import edu.ustb.yaolegou.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface UserMapper {

    @Select("select u.*, ui.userNick from user u inner join userinfo ui on u.username = ui.username where u.username=#{username}")
    public User selectByName(@Param("username") String userName);

    @Select("select u.*, ui.userNick from user u inner join userinfo ui on u.username = ui.username where ui.phone=#{phone}")
    public User selectByPhone(@Param("phone") String phone);

    @Insert("INSERT INTO user (username,password,state)"
            +"VALUES(#{userName},#{password},#{state})")
    public int insertUser(User user);

    @Insert("INSERT INTO userinfo (username,userNick,phone,sexid,isdianpu,money,dianpumoney,image)"
            +"VALUES(#{userName},#{userNick},#{phone},3,0,0,0,#{image})")
    public int insertUserInfo(User user);

}