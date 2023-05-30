package com.iwu.ywuu.service;

import com.iwu.ywuu.entity.User;
import com.iwu.ywuu.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//@service @resopnse @compoment @controller 把它整成bean
public class UserService {
    @Resource
    UserMapper userMapper;
//通过getUpdByUat查询账号对应密码，返回true登录成功，返回false登录失败
    public Boolean loginUser(String acc,String pw){
        String getpw = userMapper.getUpdByUat(acc);
        if(pw.equals(getpw)){
            return true;
        }else{
            return false;
        }
    }
//通过addUser添加一个新的user，如果account不重复，返回true，注册成功
    public Boolean addNewUser(int uid, String uaccount, String upassword, String uname){
        List<User> uat = userMapper.getUat(uaccount);
        if(uat.size()>=1){
            return false;
        }else{
            int user = userMapper.addUser(uid, uaccount, upassword, uname);
            if(user>=1){
                return true;
            }else{
                return false;
            }
        }
    }
//    通过判断输入id和account是否对应，如果对应修改密码
    public Boolean updateNewPw(int uid,String uaccount,String upassword){
       String acc = userMapper.getAccByUid(uid);
       if(acc.equals(uaccount)){
          int a= userMapper.getNewPw(upassword,uid);
          if(a>=1){
              return true;
          }else {
              return false;
          }
       }else{
           return false;
       }
    }

}
