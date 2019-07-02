package com.hpit.demo1.conrtoller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.District;
import com.hpit.demo1.entity.Street;
import com.hpit.demo1.entity.Users;
import com.hpit.demo1.service.DistrictService;
import com.hpit.demo1.service.StreetService;
import com.hpit.demo1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/koko/")
public class Conrtollers {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> getPageInfo(Integer page,Integer rows){
        PageInfo<District> pageInfo=districtService.getPageInfo(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("add")
    @ResponseBody
    public String insertSelective(District record){
        int i = districtService.insertSelective(record);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("upadte")
    @ResponseBody
    public String updateByPrimaryKeySelective(District record){
        int i = districtService.updateByPrimaryKeySelective(record);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("delete")
    @ResponseBody
    public String deleteByPrimaryKey(Integer id){
        int i = districtService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("deletef")
    @ResponseBody
    public String deletef(String ids){
        String [] arys=ids.split(",");
        Integer [] id=new Integer[arys.length];
        for (int i=0;i<arys.length;i++){
            id[i]=Integer.parseInt(arys[i]);
        }
        int deleted = districtService.deleted(id);
        return "{\"result\":"+deleted+"}";
    }


}
