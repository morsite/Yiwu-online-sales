package com.iwu.ywuu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iwu.ywuu.entity.Scom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
public interface ScomMapper extends BaseMapper<Scom> {
    @Select("select * from scom")
    public List<Scom> getFronScom();
    @Insert("insert into scom values(#{scomid},#{scomname},#{scomintr}," +
            "#{scompho},#{scomprice},#{scomnum},#{scomstate},#{scommoq}," +
            "#{freight},#{outbound})")
    public int addNewScom(int scomid,String scomname,String scomintr,String scompho,
                          int scomprice,int scomnum,String scomstate,int scommoq,
                          int freight,int outbound);
    @Update("update scom set scomname=#{scomname},scomintr=#{scomintr},  scompho=#{scompho}," +
            "scomprice=#{scomprice},scomnum=#{scomnum},scomstate=#{scomstate},scommoq=#{scommoq}" +
            ",freight=#{freight},outbound=#{outbound} where scomid=#{scomid}")
    public int updateOneScom(String scomname,String scomintr,String scompho,
                             int scomprice,int scomnum,String scomstate,int scommoq,
                             int freight,int outbound,int scomid);
    @Delete("delete from scom where scomid = #{scomid}")
    public int deleteOneScom(int scomid);
    /*仓库翻页*/


}
