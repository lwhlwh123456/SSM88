package com.hpit.demo1.conrtoller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hpit.demo1.entity.House;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shenhe/")
public class HouseControllers {
    @Autowired
    private HouseService houseService;
    //查询未审核
    @RequestMapping("getHouseByStart")
    @ResponseBody
    public Map<String,Object> getHouseByStart(Integer page,Integer rows){
        PageInfo<House> pageInfo = houseService.getHouseByStart(page, rows, 0);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //查询已审核
    @RequestMapping("getHouseByStarts")
    @ResponseBody
    public Map<String,Object> getHouseByStarts(Integer page,Integer rows){
        PageInfo<House> pageInfo = houseService.getHouseByStart(page, rows, 1);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //通过审核
    @RequestMapping("passHouse")
    @ResponseBody
    public Map<String,Object>  passHouse(String id){
        int i = houseService.passHouse(id);
        Map<String,Object> map = new HashMap<>();
        System.out.println("map = " + map);
        map.put("i",i);
        return map;
    }
}
