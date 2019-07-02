package com.hpit.demo1.conrtoller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Users;
import com.hpit.demo1.service.UsersService;
import com.hpit.demo1.util.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/coo/")
public class UsersConrtoller {
    @Autowired
    private UsersService usersService;
    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> pageInfo(UserPage userPage){
        PageInfo<Users> usersPageInfo = usersService.pageInfo(userPage);
        Map<String,Object> map=new HashMap<>();
        map.put("total",usersPageInfo.getTotal());
        map.put("rows",usersPageInfo.getList());
        return map;
        }

    @RequestMapping("add")
    @ResponseBody
    public String insertSelective(Users record){
        int i = usersService.insertSelective(record);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateByPrimaryKeySelective(Users record){
        int i = usersService.updateByPrimaryKeySelective(record);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String  deletea(String ids){
        String[] a=ids.split(",");
        Integer[] id=new Integer[a.length];
        for (int i=0;i<a.length;i++) {
            id[i]=Integer.parseInt(a[i]);
        }
        int deleteh = usersService.deletea(id);
        return "{\"result\":"+deleteh+"}";
    }
}
