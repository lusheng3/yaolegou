package edu.ustb.yaolegou.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import edu.ustb.yaolegou.dao.BannerMapper;
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

            if (u == null){
                result = "用户名不存在!";
            }else{
                if (!user.getPassword().equals(u.getPassword())){
                    result = "密码有误，请重新输入";
                }
            }

            if("true".equals(result)){
                user = u;
            }

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

    public int userAdd(User user){
        SqlSession session = null;
        int result = 0;
        try {
            session = MybatisUtil.getSession();
            user.setImage("attached/TouXiang/default.gif");
            UserMapper userMapper = session.getMapper(UserMapper.class);
            result = userMapper.insertUser(user);
            result += userMapper.insertUserInfo(user);
            session.commit();

        } catch(Exception ex){
            ex.printStackTrace();
            session.rollback();
            result = 0;
        }finally{
            //资源释放
            session.close();
        }

        return result;
    }

    public User getUserByPhone(String phone){
        SqlSession session = null;
        User user = null;
        try{
            session = MybatisUtil.getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            user = userMapper.selectByPhone(phone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    public String sendSms(String phone, String code){
        String result = null;
        //LTAI5tAUcj5XmNgEMJjHSi25
        //J9OWqch6pDv3tanJlOTIFrR13ZPS2B
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI5tAUcj5XmNgEMJjHSi25",
                        "J9OWqch6pDv3tanJlOTIFrR13ZPS2B");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId","cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",phone);
        request.putQueryParameter("SignName","yaolegou");
        request.putQueryParameter("TemplateCode","SMS_461890239");
        request.putQueryParameter("TemplateParam","{\"code\":\"" + code + "\"}");
        try{
            CommonResponse response = client.getCommonResponse(request);
            result = response.getData();
        }catch (ClientException e){
            e.printStackTrace();
        }
        return result;
    }
}
