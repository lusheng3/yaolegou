package edu.ustb.yaolegou.dao;

import edu.ustb.yaolegou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface UserMapper {

    @Select("select u.*, ui.userNick from user u inner join userinfo ui on u.username = ui.username where u.username=#{username}")
    public User selectByName(@Param("username") String userName);

}