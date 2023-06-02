package com.iwu.ywuu.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.iwu.ywuu.entity.Scom;
import com.iwu.ywuu.service.ScomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//说明它是一个controller 返回值是json类型
@RequestMapping("/scom")//设置请求路径
public class ScomController {
    @Autowired
    ScomService scomService;

    @GetMapping("/all")
    public JSON getAllScom() {
        JSONObject obj = JSONUtil.createObj();
        List<Scom> scoms = scomService.getScom();
        if (scoms.size() > 0) {
            obj.set("status", "200");
            obj.set("data", scoms);
            return obj;
        } else {
            obj.set("status", "400");
            obj.set("data", scoms);
            return obj;
        }
    }

    @PostMapping("/add")
    public JSON addScom(@RequestBody Scom scom) {
        JSONObject obj = JSONUtil.createObj();
        int sco = scomService.addOneScom(scom.getScomid(), scom.getScomname(), scom.getScomintr(), scom.getScompho(), scom.getScomprice(), scom.getScomnum(),
                scom.getScomstate(), scom.getScommoq(), scom.getFreight(), scom.getOutbound());
        if (sco > 0) {
            obj.set("status", "200");
            obj.set("data", sco);
            return obj;
        } else {
            obj.set("status", "400");
            obj.set("data", sco);
            return obj;
        }
    }

    @PostMapping("/update")
    public JSON updateScom(@RequestBody Scom scom) {
        JSONObject obj = JSONUtil.createObj();
        int sco = scomService.updateOneScom(scom.getScomname(), scom.getScomintr(), scom.getScompho(), scom.getScomprice(), scom.getScomnum(),
                scom.getScomstate(), scom.getScommoq(), scom.getFreight(), scom.getOutbound(), scom.getScomid());
        if (sco > 0) {
            obj.set("status", "200");
            obj.set("data", sco);
            return obj;
        } else {
            obj.set("status", "400");
            obj.set("data", sco);
            return obj;
        }
    }

    @PostMapping("/delete")
    public JSON deleteScom(@RequestBody Scom scom) {
        JSONObject obj = JSONUtil.createObj();
        int sco = scomService.deleteAScom(scom.getScomid());
        if (sco > 0) {
            obj.set("status", "200");
            obj.set("data", sco);
            return obj;
        } else {
            obj.set("status", "400");
            obj.set("data", sco);
            return obj;
        }
    }
    @GetMapping("/test")
    public JSON getByPage(@RequestParam int a,@RequestParam int b){
        JSONObject obj = JSONUtil.createObj();
        obj.set("data",scomService.selectByPage(a,b).getRecords());
        return obj;
    }

}

