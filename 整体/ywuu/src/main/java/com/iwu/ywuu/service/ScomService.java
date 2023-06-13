package com.iwu.ywuu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwu.ywuu.entity.Scom;
import com.iwu.ywuu.mapper.ScomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScomService {
    @Resource
    ScomMapper scomMapper;

//返回一个list对象
    public List<Scom> getScom(){
        List<Scom> fronScom = scomMapper.getFronScom();
            for (Scom i:fronScom){
                if(i.getScomstate().equals("0")){
                    i.setScomstate("否");
                }else{
                    i.setScomstate("是");
                }
            }
        return fronScom;
    }
//    添加
    public int addOneScom(int a,String b,String c,String d,int e,int f,String g,int h,int i,int j){
        int news = scomMapper.addNewScom(a,b,c,d,e,f,g,h,i,j);
        if(news>0){
            return news;
        }else{
            return 0;
        }
    }
//    修改
    public int updateOneScom(String b,String c,String d,int e,int f,String g,int h,int i,int j,int a){
    int news = scomMapper.updateOneScom(b,c,d,e,f,g,h,i,j,a);
    if(news>0){
        return news;
    }else{
        return 0;
    }
}

//删除
    public int deleteAScom(int scomid){
        int del = scomMapper.deleteOneScom(scomid);
        if(del>0){
            return del;
        }else{
            return 0;
        }
    }

    public IPage<Scom> selectByPage(int currentPage,int lines){
        return scomMapper.selectPage(new Page(currentPage,lines),null);
    }
}
