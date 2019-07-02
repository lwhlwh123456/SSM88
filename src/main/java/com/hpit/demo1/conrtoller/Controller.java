package com.hpit.demo1.conrtoller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Street;
import com.hpit.demo1.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping("/look")
public class Controller {
    @Autowired
    private StreetService streetService;
    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> getPageInfo(Integer page, Integer rows){
        PageInfo<Street> pageInfo=streetService.getPageInfo(page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String  insertSelective(Street record){
        int i = streetService.insertSelective(record);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String  updateByPrimaryKeySelective(Street record){
        int k = streetService.updateByPrimaryKeySelective(record);
        return "{\"result\":"+k+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String  deletedg(String ids){
       String[] a=ids.split(",");
      Integer[] id=new Integer[a.length];
      for (int i=0;i<a.length;i++){
          id[i]=Integer.parseInt(a[i]);
      }
        int deletedg = streetService.deletedg(id);
        return "{\"result\":"+deletedg+"}";
    }
   /* @RequestMapping("getLook")
    @ResponseBody
    public Map<String,Object> getLook(Integer page, Integer rows, Integer did) {
        PageInfo<Street> pageInfo = streetService.getLook(page, rows, did);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }*/
}
