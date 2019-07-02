package com.hpit.demo1.conrtoller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Type;
import com.hpit.demo1.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/koo/")
public class TypeConrtoller {

    @Autowired
    private TypeService typeService;

    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> getType(Integer page, Integer rows){
        PageInfo<Type> pageInfo=typeService.getType(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("add")
    @ResponseBody
    public String insertSelective(Type record){
        int i = typeService.insertSelective(record);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("update")
    @ResponseBody
    public String updateByPrimaryKeySelective(Type record){
        int i = typeService.updateByPrimaryKeySelective(record);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String  deleteh(String ids){
        String[] a=ids.split(",");
       Integer[] id=new Integer[a.length];
        for (int i=0;i<a.length;i++) {
            id[i]=Integer.parseInt(a[i]);
        }
        int deleteh = typeService.deleteh(id);
        return "{\"result\":"+deleteh+"}";
    }
}
