package edu.ustb.yaolegou.service;

import edu.ustb.yaolegou.dao.UserMapper;
import edu.ustb.yaolegou.entity.User;
import edu.ustb.yaolegou.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public String login(User user){
        SqlSession session = null;
        String result = "true";
        try {
            session = MybatisUtil.getSession();

            UserMapper userMapper = session.getMapper(UserMapper.class);
            User u= userMapper.selectByName(user.getUserName());
            if(u == null){
               result ="用户名不存在";
            }
            else if(!user.getPassword().equals(u.getPassword())){
                result = "密码有误，请重新输入";
            }
            if("true".equals(result)){
                user = u;
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        finally {
//资源释放
            if(session != null){
                session.close();
            }
        }
        return result ;
    }
    public User getUserByName (String userName) {
        SqlSession session = null;
        User user = null;
        try {
            session = MybatisUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            user = userMapper.selectByName(userName);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
