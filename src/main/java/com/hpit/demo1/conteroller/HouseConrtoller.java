package com.hpit.demo1.conteroller;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.*;
import com.hpit.demo1.service.DistrictService;
import com.hpit.demo1.service.HouseService;
import com.hpit.demo1.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lll/")
public class HouseConrtoller {
@Autowired
    private TypeService typeService;
@Autowired
private DistrictService districtService;
@Autowired
private HouseService houseService;
@RequestMapping("getHao")
public String getHao(Model model){
    List<Type> hao = typeService.getHao();
    List<District> hao1 = districtService.getAllType();
    System.out.println("hao = " + hao);
    model.addAttribute("hao",hao);
    model.addAttribute("hao1",hao1);
    return "fabu";
}
@RequestMapping("addHouse")
    public String add(House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws IOException {
    //将文件保存在服务器中  D:\\images
    String fname=pfile.getOriginalFilename();
    String expName=fname.substring(fname.lastIndexOf("."));
    String saveName=System.currentTimeMillis()+expName; //保存文件名
    File file=new File("D:\\images\\"+saveName);
    pfile.transferTo(file);  //保存
    //设置编号
    house.setId(System.currentTimeMillis()+"");
    //设置用户编号
    Users usersname = (Users) session.getAttribute("usersname");
     house.setUserId(usersname.getId());
    //设置审核状态 0  如果表中有默认值 可不设
    house.setIspass(0);
    //设置是否删除  0
    house.setIsdel(0);
    //设置图片路径
    house.setPath(saveName);

    if(houseService.addHouse(house)>0){ //保存数据
        /*调用业务
        houseService.addHouse(house); //添加信息到数据库*/
        return "redirect:/page/guanli.jsp";  //跳转页面
    }
    else{
        //成功上传的图片删除
        file.delete();
        return "redirect:goFaBu";  //跳转页面
    }

}
    @RequestMapping("getHaoHouse")
    public String getSelectHouse(Integer page,HttpSession session,Model model){
        Users usersname =(Users) session.getAttribute("usersname");
        PageInfo<House> pageInfo=houseService.getSelectHouse(page==null?1:page,10,usersname.getId());
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }

    @RequestMapping("getUpdate")
    public String getUpdate(String id, Model model){
        List<Type> hao = typeService.getHao();
        List<District> hao1 = districtService.getAllType();
        House house = houseService.getHouse(id);
        System.out.println("house = " + house);
        model.addAttribute("hao",hao);
        model.addAttribute("hao1",hao1);
        model.addAttribute("house",house);
        return "update";
    }
    @RequestMapping("upHouse")
    public String update(String tuPan,House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws IOException {
        File file = null;
        //1.修改时判断用户有没有修改图片
        if (pfile.getOriginalFilename().equals("")) {

        } else {
            //上传新的图片，删除旧的图片，设置path为上传新的图片名称
            file = new File("D\\images\\"+tuPan);
            pfile.transferTo(file);
            //设置图片名称
            house.setPath(tuPan);
        }
        if (houseService.Update(house) <= 0) {
            //成功上传的图片删除
            if (file != null) file.delete();
        }
        return "redirect:/lll/getHaoHouse";
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String id){
        int delete = houseService.delete(id);
        return "{\"result\":"+delete+"}";
    }
}
