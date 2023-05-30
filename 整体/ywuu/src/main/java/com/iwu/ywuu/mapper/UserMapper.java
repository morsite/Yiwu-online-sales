package com.iwu.ywuu.mapper;

import com.iwu.ywuu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
/*java集合 io流 线程 数据库 jdbc*/
//    增删改 返回修改行数 查 返回修改信息
//    用于登录
    @Select("select upassword from `user` where uaccount = ${uaccount}")
    public String getUpdByUat(String uaccount);
//    用于注册
    @Insert("insert into `user`(uid,uaccount,upassword,uname) values (#{uid},#{uaccount},#{upassword},#{uname})")
    public int addUser(int uid, String uaccount, String upassword, String uname);
    @Select("select * from `user` where uaccount = ${uaccount}")
    public List<User> getUat(String uaccount);
//    用于设置新密码
    @Select("select uaccount from `user` where uid = #{uid}")
    public String getAccByUid(int uid);
    @Update("update `user` set upassword = #{upassword} where uid = #{uid}")
    public int getNewPw(String upassword,int uid);
}
